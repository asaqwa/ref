package IOStream.WorkWithFiles;

import java.io.*;
import java.util.ArrayList;

/*
Чтение файла
В этой задаче тебе нужно:
Считать с консоли путь к файлу.
Вывести в консоли (на экран) содержимое файла.
Освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.

Requirements:
1. Программа должна считывать c консоли путь к файлу.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
*/

public class ByteToChar {
    public static void main(String[] args) {
        // напишите тут ваш код
        InputStream in = System.in;
        String fileName;
        System.setIn(new ByteArrayInputStream("workout\\a.txt".getBytes()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                fileName = reader.readLine();
                break;
            } catch (Exception ignored) {}
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setIn(in);
        ArrayList<Byte> bytesList = new ArrayList<>(10000);

        try {
//            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//            while (fileReader.ready()) {
            InputStream fileReader = new FileInputStream(fileName);
            while (fileReader.available()>0) {
                bytesList.add((byte)fileReader.read());
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        char[] chars = getCharsFromBytes(bytesList);
        System.out.println(String.valueOf(chars));


    }

    public static char[] getCharsFromBytes(ArrayList<Byte> bytesList) {
        byte[] bytes = new byte[bytesList.size()];
        for (int i = 0; i<bytes.length; i++) {
            bytes[i] = bytesList.get(i);
        }
        try {
            String byteConvert = new String(bytes, "UTF-8");
            return byteConvert.toCharArray();
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }
}



/*package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/*
Чтение файла

// d:\1.txt
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();


        FileInputStream fileInputStream = new FileInputStream(fileName);

        int data;

        while((data=fileInputStream.read()) != -1){
            // ((data = inStream.read()) != -1)

            System.out.print((char)data);
        }
        reader.close();
        fileInputStream.close();
    }
}






    /*
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream inStream = null;

        try {
            inStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int data = 0;

        while (true) {
            try {
                if ((data = inStream.read()) != -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(data);
        }


        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
JavaRush Solution ___________________________________________

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        System.out.print(builder.toString());

        scanner.close();
        reader.close();
    }
}


     */