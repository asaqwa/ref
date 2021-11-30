package JavaCore;


import sun.awt.windows.WBufferStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
package com.javarush.task.task15.task1515;
Статики-2
*/

public class Var2 {
    public static int A;
    public static int B;

    static { // after int MIN - will be false
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            A = Integer.parseInt(reader.readLine());
            B = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }


    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
