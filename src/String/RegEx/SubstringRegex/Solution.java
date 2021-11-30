package String.RegEx.SubstringRegex;

/*
Найти подстроку
package com.javarush.task.task22.task2202;
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Requirements:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String s) {
        int spaces = s == null ? 0 : s.length() - s.replace(" ", "").length();
        if (spaces > 3) {
            Pattern p = Pattern.compile("^[^ ]* ([^ ]* [^ ]* [^ ]* [а-яА-Яa-zA-Z0-9_]*[.!)?,]?)");
            Matcher m = p.matcher(s);
            if (m.find()) return m.group(1);
        }
        throw new TooShortStringException();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
