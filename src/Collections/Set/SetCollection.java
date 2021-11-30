package Collections.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetCollection {
    public static void main(String[] args) {
        String[] data = {"арбуз", "банан", "вишня", "груша", "дыня", "ежевика", "женьшень",
                "земляника", "ирис", "картофель"};
        Set<String> set = new HashSet<>(Arrays.asList(data));

        System.out.println(set.toString());
    }
}
