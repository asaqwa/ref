package String.Formater.FillWithZeros;

import java.util.HashMap;
import java.util.Map;

/*
Адаптация нескольких интерфейсов

package com.javarush.task.task19.task1903;
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        int cc = 38;
        int num =501234567;
        String formatted = String.format("+%d(%010d", cc,num);
        System.out.println(formatted);
        System.out.println(String.format("%s)%s-%s-%s", formatted.substring(0, 7), formatted.substring(7, 10), formatted.substring(10, 12), formatted.substring(12, 14)));

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getCompanyName() {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(incomeData.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s", incomeData.getContactLastName(), incomeData.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            String formatted = String.format("+%d(%010d", incomeData.getCountryPhoneCode(), incomeData.getPhoneNumber());
            return String.format("%s)%s-%s-%s", formatted.substring(0, 7), formatted.substring(7, 10),
                    formatted.substring(10, 12), formatted.substring(12, 14));
// JavaRush Solution
//            @Override
//            public String getPhoneNumber() {
//                String res = String.format("+%d(%2$s)%3$s-%4$s-%5$s", data.getCountryPhoneCode(),
//                        String.format("%010d", data.getPhoneNumber()).substring(0, 3),
//                        String.format("%010d", data.getPhoneNumber()).substring(3, 6),
//                        String.format("%010d", data.getPhoneNumber()).substring(6, 8),
//                        String.format("%010d", data.getPhoneNumber()).substring(8));
//
//                return res;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}