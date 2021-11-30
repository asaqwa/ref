package DateOrTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудь учесть первый день года.
*/

public class InCalendarParsing {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("FEBRUARY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        dateFormat.parse(date);   // !!!!!!!!!!!!!!! here is magic
        GregorianCalendar day = (GregorianCalendar) dateFormat.getCalendar();
        System.out.println(day.get(Calendar.DAY_OF_YEAR));
        return day.get(Calendar.DAY_OF_YEAR)%2 != 0;
    }

    /*public static boolean isDateOdd(String date) {
        Date currentDate = new Date(date);
        Date startDate = new Date(date);
        startDate.setDate(1);
        startDate.setMonth(0);
        long time = currentDate.getTime() - startDate.getTime();
        long days = time / 24 / 60 / 60000 + 1;
        return days % 2 == 1;
    }*/
}
