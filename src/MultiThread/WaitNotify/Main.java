package MultiThread.WaitNotify;

import java.util.ArrayList;
import java.util.Random;


public class Main {
    static Random r = new Random();
    static BlockingQueue queue = new BlockingQueue();
    static int taskCount = 0;

    public static void main(String[] args) {
        Worker worker = new Worker();
        Creator creator = new Creator(2);
        try {
            while (creator.isAlive()) Thread.sleep(500);

            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }

    static int getInt() {
        return r.nextInt(400) + 100;
    }

    static class Creator extends Thread {
        int tasksQuantity;

        public Creator(int quantity) {
            super("TasksCreator");
            this.tasksQuantity = quantity;
            start();
        }

        @Override
        public void run() {
            System.out.printf("Thread: %-20s is starting\r\n", getName());
            while (tasksQuantity-- > 0) {
                System.out.printf("Thread: %-20s creating new task\r\n", getName());
                Task task = new Task();
                try {
                    Thread.sleep(task.time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Thread: %-20s created the task: %s\r\n", Thread.currentThread().getName(), task);
                queue.addTask(task);
            }
            System.out.printf("Thread: %-20s has finished\r\n", getName());
        }
    }

    static class Worker extends Thread {

        public Worker() {
            super("TaskExecutor");
            start();
        }

        @Override
        public void run() {
            System.out.printf("Thread: %-20s is starting\r\n", getName());
            try {
                while (!isInterrupted()) {
                    new Thread(queue.getTask()).run();
                }
            } catch (Exception e) {
                System.out.printf("Thread: %-20s has finished\r\n", getName());
            }
        }
    }

    static class Task implements Runnable {
        int id;
        int time;

        public Task() {
            id = ++taskCount;
            time = getInt();
        }

        @Override
        public void run() {
            System.out.printf("Task %-4s is started\r\n", this);
        }

        @Override
        public String toString() {
            return id + "(" + time + "ms)";
        }
    }

    static class BlockingQueue {
        ArrayList<Task> tasks = new ArrayList<>();

        synchronized void addTask(Task task) {
            System.out.printf("Thread: %-20s with task: %s blocked monitor\r\n", Thread.currentThread().getName(), task);
            try {
                Thread.sleep(task.time / 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tasks.add(task);
            System.out.printf("Thread: %-20s added task: %s, notifies and releases monitor\r\n", Thread.currentThread().getName(), task);
            notify();
        }

        synchronized Task getTask() {
            System.out.printf("Thread: %-20s with no task   blocked monitor\r\n", Thread.currentThread().getName());
            try {
                while (tasks.isEmpty()) {
                    System.out.printf("Thread: %-20s with no task   is waiting\r\n", Thread.currentThread().getName());
                    wait();
                    System.out.printf("Thread: %-20s with no task   was notified\r\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException ignored) {
                System.out.printf("Thread: %-20s with no task stopped waiting\r\n", Thread.currentThread().getName());
            }
            Task task = tasks.remove(0);
            System.out.printf("Thread: %-20s take task: %s and released monitor\r\n", Thread.currentThread().getName(), task);
            return task;
        }
    }
}
