package Collections.Map;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Добрая Зинаида и летние каникулы

Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Requirements:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class MapEntryRemove {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] names = {"Luca", "Dana", "Fiete", "Maria", "Finn", "Noah", "Kimi", "Kai", "Andrea", "Simone", "Rory", "Jasmin", "Marion", "Skye", "Shane", "Helge", "Severin", "Leo", "Sam", "Elisa", "Sascha", "Dylan", "Lian", "Gwyn", "Yuma", "Merle", "Lynn", "Thjorven", "Bente", "Kim", "Noel", "Neo", "Mika", "Nino", "Keke", "Tomke", "Devin", "Robin", "Vivien", "Eske", "Vivian", "Toni", "Valentine", "Jael", "Amar", "Jill", "Sina", "Vada", "Tyler", "Jonah", "Ryan", "Blair", "Raven", "Ulli", "Dilan", "Ran", "Aidan", "Lio", "Shayan", "Felice", "Paris", "Courtney", "Patrice", "Phoenix", "Jona", "Janis", "Anouk", "Janne", "Malou", "Jamie", "Nika", "Elia", "Jayden", "Gabriele", "Ola", "Eike", "Anil", "Ira", "Kaya", "Bo", "Sanja", "Eren", "Mio", "Chris", "Lilian", "Ari", "Marley", "Blake", "Marian", "Adi", "Emlyn", "Alex", "Noa", "Aiko", "Jin", "Noe", "Isa", "Lou", "Yael", "Kolin"}; // 0-99
        while (map.size() < 10) {
            map.put(names[(int) (Math.random() * 100)], dateFormat.parse(months[(int) (Math.random() * 12)] + " " + ((int) (Math.random() * 31) + 1) + " " + (2000 + (int) (Math.random() * 22))));
        }
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Set<String> keys = new HashSet<>(map.keySet());
        for (String key : keys) {
            if (map.get(key).getMonth() > 4 && map.get(key).getMonth() < 8) map.remove(key);
        }
    }

    public static void removeAllSummerPeopleWithIterator(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Date> entry = mapIterator.next();
            if (entry.getValue().getMonth() > 4 && entry.getValue().getMonth() < 8) mapIterator.remove();
        }
    }

    public static void removeWithLambda(Map<String, Date> map) {
        map.entrySet().removeIf(entry -> entry.getValue().getMonth() > 4 && entry.getValue().getMonth() < 8);
    }

    public static void main(String[] args) throws ParseException {
        Locale localeR = new Locale("Ru");
        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy", localeR);
        Map<String, Date> map = createMap();
        System.out.println("Example of SimpleDateFormat(Locale RU):");
        int random = (int) (Math.random() * map.size());
        int count = 0;
        for (Map.Entry<String, Date> randomEntry : map.entrySet()) {
            if (count == random)
                System.out.println(randomEntry.getKey() + " / " + dateFormat.format(randomEntry.getValue()));
            count++;
        }
        Map<String, Date> mapForIterator = new HashMap<>(map);
        Map<String, Date> mapForLambda = new HashMap<>(map);

        System.out.println("Map size before removing peoples with summer months: - " + map.size());
        removeAllSummerPeople(map);
        System.out.println("Map size after removing peoples with summer months: - " + map.size());
        System.out.println("Copy before with Iterator: - " + mapForIterator.size());
        removeAllSummerPeopleWithIterator(mapForIterator);
        System.out.println("Copy after with Iterator: - " + mapForIterator.size());
        System.out.println("Copy before with Lambda: - " + mapForLambda.size());
        removeWithLambda(mapForLambda);
        System.out.println("Copy after with Lambda: - " + mapForLambda.size());

    }
}
