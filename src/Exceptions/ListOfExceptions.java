package Exceptions;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
Заполни список exceptions десятью различными исключениями.
*/

public class ListOfExceptions {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {   // 2
            String s = null;
            int i = Integer.parseInt(s);
            System.out.println(s);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 3
            int[] array = new int[3];
            array[5] = 4;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 4
            Object[] obj = new String[4];
            obj[0] = 'r';
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 5
            Object obj = new Object();
            System.out.print((Byte)obj);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 6
            String[] s = new String[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 7
            String s = null;
            s.length();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 8
            String s = "hello";
            char f = s.charAt(10);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 9
            throw new InterruptedException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {   // 10
            exceptions.add(new Exception("JavaRush"));
        } catch (Exception e) {
            exceptions.add(e);
        }


    }
}
