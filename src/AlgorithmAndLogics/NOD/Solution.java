package AlgorithmAndLogics.NOD;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
НОД

Давай найдем наибольший общий делитель (НОД). Для этого:
Введи с клавиатуры 2 целых положительных числа.
Выведи в консоли наибольший общий делитель.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        System.out.println(nod(a, b));
    }

    public static int nod(int a, int b) {
        int max, min;
        if (a>b) {
            max = a; min = b;
        } else {
            min = a; max = b;
        }
        int divider;
        while (true) {
            if ((divider = max % min)==0) return min;
            else if (divider == 1) break;
            else {
                max = min;
                min = divider;
            }
        }
        return 1;
    }
}

// JavaRush
/*public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        System.out.println(getNOD(first, second));
    }

    private static int getNOD(int first, int second) {
        if (first < 1 || second < 1) {
            throw new IllegalArgumentException();
        }

        while (first != second) {
            if (first > second) {
                first -= second;
            }
            if (second > first) {
                second -= first;
            }
        }
        return first;
    }
}
*/
