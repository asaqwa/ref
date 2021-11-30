package MultiThread.NotVolatileVariables;

import java.util.ArrayList;
import java.util.List;

/*
Один для всех, все - для одного

1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.
2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
*/

public class Solution {
    public static byte threadCount = 3;
    static List<Thread> threads = new ArrayList<Thread>(threadCount);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        //add your code here - добавь код тут
        for (Thread t : threads) t.interrupt();
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < threadCount; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String sharedResource;

        public Water(String sharedResource) {
            this.sharedResource = sharedResource;
        }

        public void run() {
            //fix 2 variables - исправь 2 переменных
            boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted(); // always true
            /*для каждого потока, который обращается к объекту, создаются свои локальные (для потока) копии переменных. И у каждого потока может храниться свое значение переменной.
А чтобы локальные копии не создавались и у всех потоков была ссылка на одну и ту же переменную, нужно при объявлении переменной указывать модификатор volatile.*/
            String threadName = Thread.currentThread().getName(); // not volatile
/*1) boolean isCurrentThreadInterrupted = false;
2) while (true)
ничего не меняется. задача выполняется. потому что мы тупо вручную прерываем нить, нам всё равно что там в переменной isCurrentThreadInterrupted  и какое там условие в цикле while.
interrupt() не учитывает эти параметры, на то он и interrupt().*/
            try {
                while (!isCurrentThreadInterrupted) {  // always true

                    System.out.println("Объект " + sharedResource + ", нить " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {  // the program ends through exception. this is not visible since the exception is not handled
            }
        }
    }
}
