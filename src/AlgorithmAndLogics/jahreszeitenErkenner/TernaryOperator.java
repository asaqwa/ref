package AlgorithmAndLogics.jahreszeitenErkenner;

public class TernaryOperator {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
        checkSeason(33);
    }

    public static void checkSeason(int month) {
        System.out.println(month<1 || month>12 ? "неверный номер месяца" :
                month < 3 || month == 12 ? "зима" :
                    month < 6 ? "весна" :
                        month < 9 ? "лето" : "осень");
    }
}
