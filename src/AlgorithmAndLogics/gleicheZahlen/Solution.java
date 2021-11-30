package AlgorithmAndLogics.gleicheZahlen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Существует ли пара?

Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел.
Если все три числа равны между собой, то вывести все три.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();

        if (a==b || a==c) {
            if (b==c) System.out.println(a +" "+ a +" "+ a);
            else System.out.println(a +" "+ a);
        }
        else if (b==c) System.out.println(b +" "+ b);
    }
}