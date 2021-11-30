package AlgorithmAndLogics.jahreszeitenErkenner;

/*
Время года
*/

public class IfElse {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
        checkSeason(77);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        if (month >= 3 && month <= 5) System.out.println("весна");
        else if (month >= 6 && month <= 8) System.out.println("лето");
        else if (month >= 9 && month <= 11) System.out.println("осень");
        else if (month >= 1 && month <= 12) System.out.println("зима");
        else System.out.println("неверный номер месяца");
    }
}
