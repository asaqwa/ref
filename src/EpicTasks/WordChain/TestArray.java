package EpicTasks.WordChain;

import java.util.ArrayList;

public class TestArray {
    static ArrayList<String[]> getTest() {
        ArrayList<String[]> list = new ArrayList<>();
        String[] words0 = new String[] {"Дербент", "Якутск", "Арзамас", "Рог", "Киев", "Кувшиново", "Капустин-Яр", "Стокгольм", "Флоренция", "Глен-Хоп", "Тобольск", "Нью-Йорк", "Афины", "Муром", "Осташков", "Прага", "Кострома", "Вена", "Амстердам", "Мельбурн", "Волгоград", "Минск"};
        String[] words1 = new String[] {"Киев", "Винница", "Нью-Йорк", "Киров", "Амстердам", "Вена", "Мельбурн"};
        String[] words2 = new String[] {"Киев", "Нью-Йорк", "Афины", "Прага", "Вена", "Амстердам", "Мельбурн", "Алушта"};
        String[] words3 = new String[] {"Венеция", "Ялта", "Минск", "Амстердам", "Москва", "Алушта", "Атланта", "Афины", "Ысити", "Столькольм", "Исбук", "Курск", "Кишинев", "Вена", "Астрахань", "Ьсити", "Иерусалим", "Мюнхен", "Норильск", "Канзас", "Киев"};
        String[] words4 = new String[] {"Киев", "Нью-Йорк", "Амстердам", "Вена", "Мельбурн", "Милан"};
        String[] words5 = new String[] {"Антверпен", "Прага", "Алушта"};
        String[] words6 = new String[] {"Киев", "Нью-Йорк", "Роттердам", "Вена", "Мельбурн"};
        String[] words7 = new String[] {"alpha", "elephant", "kick", "linea", "android", "eels", "kill", "sum", "eye", "spud", "drink", "even", "bee", "dad", "num", "tea", "test", "sims", "apple", "mob", "mate"};
        String[] words8 = new String[] {"test", "sum", "num", "kill", "sims", "mate", "even", "dad", "android", "eye", "kick", "elephant", "drink", "alpha", "eels", "bee", "mob", "linea", "tea", "apple"};
        list.add(words0); list.add(words1); list.add(words2); list.add(words3); list.add(words4); list.add(words5); list.add(words6); list.add(words7); list.add(words8);
        return list;
    }
}
