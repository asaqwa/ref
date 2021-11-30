package Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {
    public static void main(String[] args) {
        Map<String, String> map = getMap();

        // EntrySet !!!!

        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

        // Keys !!!!!!!
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // Values !!!!!!!!!!
        for (String value : map.values()) {
            System.out.println(value);
        }
    }


    static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");
        return map;
    }
}
