package EpicTasks.ArmstrongsNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Алгоритмы-числа

multithreading
*/

public class Solution {
    static private long minCurrent;
    static private long maxCurrent;
    static private int digitsCurrent = 0;
    static private int[] currentNumber;
    static private long[] powerNumbers;
    static private final ArrayList<Long> armsNum = new ArrayList<>();
    static private int digits;
    static private long N;


    public static long[] getNumbers(long N) {
        digits = howManyDigits(N);
        Solution.N = N;
        while (++digitsCurrent <= digits) {
            findTheNumbers();
        }

        Collections.sort(armsNum);
        return getArray(armsNum);
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a));
    }

    private static long getCurrentMax(int digits) {
        String number9 = "999999999999999999";
        if (digits < 19) return Long.parseLong(number9.substring(18-digits));
        return Long.MAX_VALUE; // Max Long = 9223372036854775807
    }

    private static long getCurrentMIn(int digits) {
        String number9 = "1000000000000000000";
        return Long.parseLong(number9.substring(0, digits));
    }

    private static int howManyDigits(long N) {
        long p = 10;
        for (int i = 1; i < 19; i++) {
            if (N < p) return i;
            p *= 10;
        }
        return 19;
    }

    private static long[] getArray(ArrayList<Long> longs) {
        long[] result = new long[longs.size()];
        for (int i = 0; i < longs.size(); i++) {
            result[i] = longs.get(i);
        }
        return result;
    }

    private static long[] getPowerNumbers(int pow) {
        long[] result = new long[10];
        result[1] = 1;
        for (int i = 2; i < 10; i++) {
            result[i] = binaryPower(i, pow);
        }
        return result;
    }

    private static long binaryPower(long b, int e) {
        long v = 1;
        while(e > 0) {
            if((e & 1) != 0) {
                v *= b;
            }
            b *= b;
            e >>= 1;
        }
        return v;
    }

    private static int[] getDigits(long number, int digits) {
        int[] result = new int[digits];
        int i = 0;
        while(number > 0){
            result[i++] = (int) (number%10);
            number /= 10;
        }
        return result;
    }

    private static int[] getNumbersMap(int[] number) {
        int[] numbersMap = new int[10];
        for (int i : number) numbersMap[i]++;
        return numbersMap;
    }

    private static void findTheNumbers() {
        maxCurrent = digitsCurrent == digits ? N :getCurrentMax(digitsCurrent);
        minCurrent = getCurrentMIn(digitsCurrent);
        powerNumbers = getPowerNumbers(digitsCurrent);
        currentNumber = new int[digitsCurrent];
        recursion(0, true);
    }

    private static void recursion(int index, boolean first) {
        if (index + 1 == digitsCurrent) {
            int i = first ? 0 : currentNumber[index-1];
            while (i < 10) {
                currentNumber[index] = i++;
                long newNumber = 0;
                for (int digit : currentNumber) newNumber += powerNumbers[digit];
                if (newNumber > maxCurrent || newNumber < 0) return;
                if (newNumber < minCurrent) continue;
                if (Arrays.equals(getNumbersMap(currentNumber), getNumbersMap(getDigits(newNumber, digitsCurrent))))
                    armsNum.add(newNumber);
            }
        } else if (index > 0) {
            int i = currentNumber[index-1];
            while (i < 10) {
                currentNumber[index] = i++;
                recursion(index+1, false);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                currentNumber[0] = i;
                recursion(index+1, false);
            }
        }
    }
}