package String.RegEx.FindFromOperatorOR;

import java.io.*;
import java.util.regex.*;

/*
Выделяем числа

Считать с консоли 2 пути к файлам.
Вывести во второй файл все целые числа, которые есть в первом файле (54у не является числом).
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1

.453 or 345. are also not numbers
*/

public class Solution {
    public static void main(String[] args) {
        String file1 = "workout\\a.txt";
        String file2 = "workout\\out.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            file1 = reader.readLine();
//            file2 = reader.readLine();
        } catch (Exception e) { e.printStackTrace(); }

        StringBuilder data = new StringBuilder();
        Pattern pattern = Pattern.compile("(^|\\s)(\\d+)(\\s|$)");
        try (BufferedReader fReader = new BufferedReader(new FileReader(file1))) {
            while (fReader.ready()) {
                Matcher m = pattern.matcher(fReader.readLine());
                int index = -1;
                while (m.find(++index)) {
                    data.append(m.group(2)).append(" ");
                    index = m.start();
                }
            }
        } catch (Exception e) { e.printStackTrace(); }

        try (FileWriter fWriter = new FileWriter(file2)) {
            fWriter.write(data.toString().trim());
        } catch (Exception e) { e.printStackTrace(); }
    }
}