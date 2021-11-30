package AlgorithmAndLogics.jahreszeitenErkenner;

public class Array {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
        checkSeason(77);
    }

    public static void checkSeason(int month) {
        if (month<1 || month >12) System.out.println("неверный номер месяца");
        else {
            String[] months = new String[]{"зима", "зима",
                    "весна", "весна", "весна",
                    "лето", "лето", "лето",
                    "осень", "осень", "осень",
                    "зима"};
            System.out.println(months[month-1]);
        }
    }
}