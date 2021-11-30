package TimeMessure;

import java.util.Date;
import java.util.Random;

public class RandomTest {
    static int index = 1000000;

    public static void main(String[] args) {

        testMethodRandom(6);
        testMethodNewRandom(6);
        testMethodMathRandom(6);
        testMethodRandom(600);
        testMethodNewRandom(600);
        testMethodMathRandom(600);
        testMethodRandom(600000);
        testMethodNewRandom(600000);
        testMethodMathRandom(600000);
    }

    public static void testMethodRandom(int upTo) {
        long start = new Date().getTime();
        Random random = new Random();
        int t = 0;
        for (int i = 0; i < index; i++) {
            int x = random.nextInt(upTo);
            if (x == upTo-1) t++;
        }
        long time = new Date().getTime()-start;
        System.out.printf("%s%10s%10d%8s%10d%10d%n", "testMethodRandom", "value", upTo, "time", time, t);
    }

    public static void testMethodNewRandom(int upTo) {
        long start = new Date().getTime();
        int t = 0;
        for (int i = 0; i < index; i++) {
            Random random = new Random();
            int x = random.nextInt(upTo);
            if (x == upTo-1) t++;
        }
        long time = new Date().getTime()-start;
        System.out.printf("%s%10s%10d%8s%10d%10d%n", "testMethodRandom", "value", upTo, "time", time, t);
    }

    public static void testMethodMathRandom(int upTo) {
        long start = new Date().getTime();
        int t = 0;
        for (int i = 0; i < index; i++) {
            int x = (int) (Math.random()*upTo);
            if (x == upTo-1) t++;
        }
        long time = new Date().getTime()-start;
        System.out.printf("%s%10s%10d%8s%10d%10d%n", "testMethodRandom", "value", upTo, "time", time, t);
    }
}
