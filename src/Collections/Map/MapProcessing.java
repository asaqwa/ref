package Collections.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Requirements:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.*/

public class MapProcessing {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>(10);
        for (int i = 1; i<=10; i++) {
            map.put(new String("LastName " + i), "Name ");
        }
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        return Collections.frequency(map.values(), name);
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        return map.containsKey(lastName) ? 1 : 0;
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        map.forEach((k, v) -> System.out.println(k + " " +v));
        System.out.println(getCountTheSameFirstName(map, "Name "));
        System.out.println(getCountTheSameLastName(map, "LastName 1"));
    }
}
