package Recursion.TagsCutter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.*;

/*
Знакомство с тегами
package com.javarush.task.task19.task1918;

Считай с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Requirements:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

public class Solution {
    public static void main(String[] args) {
        args = new String[] {"span"};
        String fileName = "workout\\html.txt";

        if (args == null || args.length == 0) return;
        String searchingTagRegex = String.format("(<\\s*/?\\s*%s\\b.*?>)", args[0]);
        String endTagRegex = String.format("<\\s*/\\s*%s\\b.*?>", args[0]);
        Pattern pattern = Pattern.compile(searchingTagRegex);
        ArrayList<String> tags = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName = reader.readLine();
        } catch (Exception e) { e.printStackTrace(); }

        StringBuilder fileData = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            while (reader.ready()) fileData.append((char) reader.read());
        } catch (Exception e) {e.printStackTrace();}
        String data = fileData.toString().replaceAll("[\\r\\n]+", "").replaceAll("\\s+", " ");

        Matcher m = pattern.matcher(data);
        int beginIndex = -1;
        while (m.find()) {
            beginIndex = m.start();
            if (m.group(1).matches(endTagRegex)) continue;
            if (addCloseTag(tags, m, data, endTagRegex) < 0) break;
        }

        int i = 0;
        for (String s : tags) System.out.println(s + " " + ++i);
    }

    static int addCloseTag(ArrayList tags, Matcher m, String data, String endTagRegex) {
        int tagsIndex = tags.size();
        int beginIndex = m.start();
        while (m.find()) {
            if (m.group(1).matches(endTagRegex)) {
                tags.add(tagsIndex, data.substring(beginIndex, m.end()));
                return 1;
            } else {
                if (addCloseTag(tags, m, data, endTagRegex) < 0) return -1;
            }
        }
        return -1;
    }
}
