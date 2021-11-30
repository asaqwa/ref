package Properties;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
package com.javarush.task.task20.task2003;

*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties prop = new Properties();
        prop.putAll(runtimeStorage);
        prop.store(outputStream,"");
        outputStream.flush();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties prop = new Properties();
        prop.load(inputStream);
        Map step1 = prop;
        Map<String, String> step2 = (Map<String, String>) step1;
        runtimeStorage = new HashMap<>(step2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            runtimeStorage.put(String.valueOf(i), String.valueOf(i));
        }
        Map<String, String> firstMap = runtimeStorage;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (OutputStream out = new FileOutputStream("workout\\properties.pro")) {
            save(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream("workout\\properties.pro")) {
            load(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage.equals(firstMap));
    }
}
