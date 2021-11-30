package String.Formater.StringFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormating {
    public static void main(String[] args) {
        int ten = 10;
        System.out.printf("%s%" + ten +"s\r\n", "testMethodRandom", "two");


        int maxId = 0;
        args = new String[] {"-c", "Herd", "2599,99", "12345"};
        String newLine = String.format("%-8d%-30s%-8s%-4s", ++maxId, args[1], args[2], args[3]);
        System.out.println(newLine);


        // FLOAT FORMAT !!!!!!!!!!    attention the result is rounded

        int spaceCount = 95, charsCount = 471;
        double result = 100.0*spaceCount/charsCount;
        System.out.printf("%.2f\n", result);


        /*

        Небольшой спойлер (лучше сначала разобраться в теме, а потом читать код ниже):

String id = String.format("%-8d", ++lastId);
String productName = String.format("%-30.30s", args[1]);
String price = String.format(Locale.ROOT, "%-8.2f", Double.parseDouble(args[2]));
String quantity = String.format("%-4d", Integer.parseInt(args[3]));

Можно сделать так, как показал Иван Кирсанов в комментариях ниже (групповое форматирование), но в этой записи есть неточности:

writer.write(String.format("%8d%30.30s%8.8s%4.4s",max+1,args[1],args[2],args[3]));


Единственное что не понятно зачем пишут так :   %8.8s
Для меня понятно :   %8s  или %-8s
Но зачем там точка и ещё 8 .          --->>                %8(.8)s  - то что в скобках не понятно.
Ответить
0
there there
Уровень 41, Санкт-Петербург
9 августа 2019, 13:25
цифра до точки - ширина строки, после точки - максимальное количество символов*/

        // split with limit

        String[] personData = "Иванов Иван Иванович 31 12 1950".split("\\s", 4);
        for (String s : personData) System.out.println(s);
        Date date = null;
        try {
            date = new SimpleDateFormat("d M yyyy").parse(personData[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());


    }   // MAIN
}
