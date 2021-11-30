package ArrayEdit;

import java.util.ArrayList;
import java.util.ListIterator;

/*
Продолжаем мыть раму
1. Создай список из слов "мама", "мыла", "раму".
2. После каждого слова вставь в список строку, содержащую слово "именно".
3. Вывести результат на экран, каждый элемент списка с новой строки.
                        3 Lösungen
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> mama = new ArrayList<>();
        mama.add("мама");
        mama.add("мыла");
        mama.add("раму");

//        for (int i = mama.size(); i>0; i--) {
//            mama.add(i, "именно");
//        }

        ListIterator<String> iterate = mama.listIterator();
        while (iterate.hasNext()) {
            iterate.next();
            iterate.add("именно");
        }

        for (String s : mama) System.out.println(s);
    }
}
