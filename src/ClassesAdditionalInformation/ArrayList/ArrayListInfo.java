package ClassesAdditionalInformation.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ArrayListInfo {
    public static void main(String[] args) {

        ArrayList<Cat> cats = new ArrayList<>();

        Cat thomas = new Cat("Томас");
        Cat behemoth = new Cat("Бегемот");
        Cat philipp = new Cat("Филипп Маркович");
        Cat pushok = new Cat("Пушок");

        cats.add(thomas);
        cats.add(behemoth);
        cats.add(philipp);
        cats.add(pushok);

        Cat[] catsArray = cats.toArray(new Cat[0]);
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        /*в метод toArray() мы передали пустой массив. Это не ошибка. Внутри класса ArrayList данный метод реализован таким образом, что передача пустого массива увеличивает его производительность.*/

        System.out.println(Arrays.toString(catsArray));

        ArrayList<Cat> cats2 = new ArrayList<>(Arrays.asList(catsArray));

        Cat cat = cats2.remove(1);
        // remove returns Object !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        cats2.remove(thomas);

        System.out.println(cat);
        System.out.println(cats2.toString());

        // reverse iterator
        ListIterator<Cat> listIterator = cats.listIterator(cats.size());
        while (listIterator.hasPrevious()) System.out.println(listIterator.previous());

    }

    public static class Cat {
        String name;
        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
