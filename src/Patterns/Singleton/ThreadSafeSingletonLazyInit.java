package Patterns.Singleton;

// Ленивую инициализацию (Lazy Initialization) еще называют отложенной инициализацией. Это прием в программировании, когда ресурсоемкая операция (а создание объекта – это ресурсоемкая операция) выполняется по требованию, а не заблаговременно.

public class ThreadSafeSingletonLazyInit {
    private static volatile ThreadSafeSingletonLazyInit instance = null;

    private ThreadSafeSingletonLazyInit() {
    }

    public static ThreadSafeSingletonLazyInit getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonLazyInit.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonLazyInit();
                }
            }
        }
        return instance;
    }

}
