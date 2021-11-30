package String.RegEx.Replacement;


class Ideone {
    public static void main(String[] args) {
        String[] tests = {"some string with 'the data i want' inside", "foo bar", "12345678name567890123456name123456name123456781234"};
        for (String myData : tests) {
            String target = myData.replaceAll("[^']*(?:'(.*?)')?.*", "$1"); // $1 номер вырезанной части текста
            String target2 = myData.replaceAll("^(\\d+).*(\\d++)", "$1");
            System.out.println(myData + " --> " + target2);
        }
    }
}