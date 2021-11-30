package String.RegEx.FilesCombine;

import java.io.*;
import java.util.regex.*;
import java.util.Set;
import java.util.TreeSet;

/*
Собираем файл
package com.javarush.task.task18.task1825;

Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Requirements:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    static Set<FilePart> fileParts = new TreeSet<>();
    public static void main(String[] args) {
        String inputData = "workout\\Lion.avi.part111\nworkout\\Lion.avi.part4\nworkout\\Lion.avi.part33\nworkout\\Lion.avi.part2\nworkout\\Lion.avi.part3\nworkout\\Lion.avi.part1\nend\nworkout\\Lion.avi.part444";

        try (BufferedReader reader = new BufferedReader(new CharArrayReader(inputData.toCharArray()))) {
            while (reader.ready()) {
                String s = reader.readLine();
                if ("end".equals(s)) break;
                try {
                    fileParts.add(new FilePart(s));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileOutputStream fWriter = new FileOutputStream(FilePart.outputFileName)) {
            for (FilePart filePart : fileParts) {
                try (InputStream fReader = new FileInputStream(filePart.fullFileName)) {
                    byte[] buffer = new byte[fReader.available()];
                    fReader.read(buffer);
                    fWriter.write(buffer);
                    System.out.printf("File : %-30s was written.\n", filePart.fullFileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static class FilePart implements Comparable<FilePart> {
        private static final Pattern pattern = Pattern.compile("(.+)\\.part(\\d+)$");
        static String outputFileName;

        int id;
        String fullFileName;

        public FilePart(String line) {
            if (line == null || line.isEmpty() || !(line.matches(".+\\.part\\d+"))) throw new IllegalArgumentException("Wrong input data.");

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (outputFileName == null) outputFileName = matcher.group(1);
                else if (!outputFileName.equals(matcher.group(1))) throw new IllegalArgumentException("Wrong file name.");
                id = Integer.parseInt(matcher.group(2));
            }
            fullFileName = line;
        }

        @Override
        public int compareTo(FilePart o) {
            return id - o.id;
        }

        @Override
        public String toString() {
            return String.format("File part #%-8dFile name: %s", id, outputFileName);
        }
    }
}
