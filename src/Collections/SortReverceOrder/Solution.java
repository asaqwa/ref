package Collections.SortReverceOrder;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция

Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Requirements:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new ByteArrayInputStream(("Вишня\n" + "1\n" + "Боб\n" + "3\n" + "Яблоко\n" + "22\n" + "0\n" + "Арбуз\n" + "\n").getBytes()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        while (!line.isEmpty()) {
            list.add(line);
            line = reader.readLine();
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        boolean[] isNumber = new boolean[array.length];
        ArrayList<String> strings = new ArrayList<>((int)(array.length*0.75));
        ArrayList<Integer> numbers = new ArrayList<>((int)(array.length*0.75));
        for (int i = 0; i < array.length; i++) {
            String next = array[i];
            if (isNumber(next)) {
                isNumber[i] = true;
                numbers.add(Integer.parseInt(next));
            } else {
                strings.add(next);
            }
        }

        strings.sort(Collections.reverseOrder());
        Collections.sort(numbers);

        for (int i = 0; i < array.length; i++) {
            array[i] = isNumber[i] ? numbers.remove(numbers.size()-1).toString() : strings.remove(strings.size()-1);
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
