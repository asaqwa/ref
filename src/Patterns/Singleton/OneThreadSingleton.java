package Patterns.Singleton;

public class OneThreadSingleton {
    private static OneThreadSingleton instance = new OneThreadSingleton();

    private OneThreadSingleton() {
    }

    public static OneThreadSingleton getInstance() {
        return instance;
    }
}
