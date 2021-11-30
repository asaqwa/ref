package EpicTasks.WordChain;


import java.io.*;
import java.util.*;

/*
Составить цепочку слов
package com.javarush.task.task22.task2209;
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.


Requirements:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                (new BufferedReader(new InputStreamReader(System.in)).readLine())))) {
            while (reader.ready()) data.addAll(Arrays.asList (reader.readLine().split(" ")));
        } catch (Exception e) { e.printStackTrace(); }

        String[] words = data.toArray(new String[0]);
        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
//
//
//        ArrayList<String[]> list = TestArray.getTest();
//        for (String[] words: list) {
//            System.out.println(words.length);
//            StringBuilder test = getLine(words);
//            System.out.println(test.toString());
//        }
//
    }

    public static StringBuilder getLine(String... words) {
        Graph graph = new Graph(words);
        return graph.getLongestSequence();
    }

}
