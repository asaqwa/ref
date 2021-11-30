package TimeMessure.DigitsInNumber;

// Max Long = 9223372036854775807

public class Test {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (long i = 100000000000000L; i < 100001000000000L; i++) {
            if (check1(i)>15) System.out.print("ERROR  ");
        }
        System.out.println("check1 result = " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        for (long i = 100000000000000L; i < 100001000000000L; i++) {
            if (check2(i)>15) System.out.print("ERROR  ");
        }
        System.out.println("check2 result = " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        for (long i = 100000000000000L; i < 100001000000000L; i++) {
            if (check3(i)>15) System.out.print("ERROR  ");
        }
        System.out.println("check3 result = " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        for (long i = 100000000000000L; i < 100001000000000L; i++) {
            if (check4(i)>15) System.out.print("ERROR  ");
        }
        System.out.println("check4 result = " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        for (long i = 100000000000000L; i < 100001000000000L; i++) {
            if (check5(i)>15) System.out.print("ERROR  ");
        }
        System.out.println("check5 result = " + (System.currentTimeMillis() - a));

//        for (long i = 100000000000000L; i < 100001000000000L; i++) {
//            for (int i = 1000000000; i < Integer.MAX_VALUE; i++) {
//        System.out.println(check1(100000000000000L));
    }

    private static int check1(long N) {
        long p = 10;
        for (int i = 1; i < 19; i++) {
            if (N < p) return i;
            p *= 10;
        }
        return 19;
    }

    private static int check2(long N) {
        int count = (N == 0) ? 1 : 0;

        while (N != 0) {
            count++;
            N /= 10;
        }

        return count;
    }

    public static int check3(long N) {
        return (N == 0) ? 1 : (int) Math.ceil(Math.log10(N + 0.5));
    }

    private static int check4(long N) {
        return String.valueOf(N).length();
    }

    private static int check5(long N) {
        return ("" +N).length();
    }
}
