package AlgorithmAndLogics.daysInYear;
/*
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(reader.readLine());
        reader.close();
        int days = 365;
        if (year%400==0 || (year%4==0 && year%100!=0)) days = 366;
        System.out.println("количество дней в году: " + days);
    }
}