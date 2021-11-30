package TimeMessure.GetDigitsFromNumber;

import java.util.Arrays;

// Max Long = 9223372036854775807
public class Tester {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        boolean tr = true;
        for (int i = 1000000; i < 10000000; i++) {
            int[] number = getDigits(i, 7);
            if (number[0] == 5 && tr) {
                System.out.println(Arrays.toString(number));
                tr = false;
            }
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    static private int[] getDigits(int number, int digits) {
        int[] result = new int[digits];
        int i = 0;
        while(number > 0){
            result[i++] = (number%10);
            number /= 10;
        }
        return result;
    }

//    static private int[] getDigits(int number, int digits) {
//        char[] c = ("" + number).toCharArray();
//        int[] result = new int[c.length];
//        for (int i = 0 ; i < result.length ; i++)
//            result[i] = c[i] - '0';
//
//        return result;
//    }
}
