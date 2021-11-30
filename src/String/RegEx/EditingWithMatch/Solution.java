package String.RegEx.EditingWithMatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

/*
Замена чисел
package com.javarush.task.task19.task1924;

1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12.
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать.
Переменная имеет имя file1.
110 - это число.


Requirements:
1. Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        String[] numbers = new String[] {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать"};
        for (int i = 0; i < 13; i++) {
            map.put(i, numbers[i]);
        }
    }

    public static void main(String[] args) {
//      (?<=\p{P}|\s|^)(\d{1,2})(?=\p{P}|\s|$)          // any two-digit number
//      (?<=\p{P}|\s|^)(\d|1[0-2])(?=\p{P}|\s|$)        // a number from 0 to 12

        String fileName = "output\\all.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//             fileName = reader.readLine();
        } catch (Exception e) {e.printStackTrace();}

        StringBuilder data = new StringBuilder("0 Это стоит 1 бакс, а вот это - 11.\nПеременная имеет имя file1.\n110 - это число. 12");

//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//            while (fileReader.ready()) data.append(fileReader.readLine()).append("\r\n");
//        } catch (Exception e) {e.printStackTrace();}

        Pattern pattern = Pattern.compile("\\b(\\d|1[0-2])\\b");
        Matcher m = pattern.matcher("0 Это стоит 1 бакс, а вот это - 11.\n" +
                "Переменная12 имеет имя file1.\n" +
                "110 - это число.");
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(result, map.get(Integer.parseInt(m.group(1))));
        }
        m.appendTail(result);
        System.out.println(result);
    }
}

/*
        JavaRush Solution

        String fileLine;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((fileLine = in.readLine()) != null) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(fileLine);
            }
        } catch (IOException ignore) {

        }*/
