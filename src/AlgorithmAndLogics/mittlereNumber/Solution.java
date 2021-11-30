package AlgorithmAndLogics.mittlereNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Как-то средненько
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.


Requirements:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить среднее из трех чисел.
4. Если все числа равны, вывести любое из них.
5. Если два числа из трех равны, вывести любое из двух.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();

        int mid;
        if (a>b) {
            if (b>c) mid = b;
            else if (a>c) mid = c;
            else mid = a;
        }
        else if (a>c) mid = a;
        else if (b>c) mid = c;
        else mid = b;

        System.out.println(mid);

    }
}
// System.out.println(a+b+c-Math.min(Math.min(a,b),c)-Math.max(Math.max(a,b),c));


/*
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(rd.readLine());
        int b = Integer.parseInt(rd.readLine());
        int c = Integer.parseInt(rd.readLine());
        int x = 0;
        if (a>b && b>c || a<b && b<c || a==b || b==c)
            x=b;
        if (b>c && c>a || b<c && c<a || c==a)
            x=c;
        if (c>a && a>b || c<a && a<b)
            x=a;
        System.out.println(x);
    }
}

*/