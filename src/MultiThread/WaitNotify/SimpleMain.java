package MultiThread.WaitNotify;

import java.util.ArrayList;

public class SimpleMain {
    static int taskCount = 0;
    static int getTaskCount = 0;

    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue();

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
    //                    Runnable task = queue.get();
    //                    task.run();
                        new Thread(queue.get()).start();
                    }
                } catch (Exception e) {
                    System.out.println("worker was stopped");
                }
            }
        });

        worker.start();

        for (int i = 0; i < 10; i++) {
            queue.put(getTask());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }

    static Runnable getTask() {
        return new Runnable() {
            String name = String.format("Thread Task: %-3d", ++taskCount);
            @Override
            public void run() {
                System.out.println("task started:  " + name);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task finished: " + name);
            }
        };
    }

    static class BlockingQueue {
        ArrayList<Runnable> tasks = new ArrayList<>();

        synchronized Runnable get() {
            if (tasks.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("queue is empty, process getRunnable was interrupted");;
                }
            }
            return tasks.remove(tasks.size()-1);
        }

        synchronized void put(Runnable task) {
            tasks.add(task);
            notify();
        }
    }
}
