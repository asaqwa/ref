package String.RegEx.WordsCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.*;

/*
Считаем слово
package com.javarush.task.task19.task1907;

JavaRush Solution
        String replacedString = text.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

        for (String x : replacedString.split(" ")) {
            if (x.equals("world")) {
                counter++;
            }
        }

*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "workout\\a.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // fileName = reader.readLine();
        } catch (Exception e) { e.printStackTrace();}

        Pattern pattern = Pattern.compile("\\bworld\\b");
        int worldCount = 0;
        try (BufferedReader fReader = new BufferedReader(new FileReader(fileName))) {
            while (fReader.ready()) {
                Matcher s = pattern.matcher(fReader.readLine());
                while (s.find()) {
                    worldCount++;
                }
            }
        } catch (Exception e) { e.printStackTrace();}

        System.out.println(worldCount);

    } // main

}
