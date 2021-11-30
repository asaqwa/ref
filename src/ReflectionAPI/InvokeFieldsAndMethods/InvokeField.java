package ReflectionAPI.InvokeFieldsAndMethods;

import java.lang.reflect.Field;

public class InvokeField {
    public static Cat createCat() {

        Class clazz = null;
        Cat cat = null;
        try {
            clazz = Class.forName("ReflectionAPI.InvokeFieldsAndMethods.Cat");
            cat = (Cat) clazz.newInstance();

            //с полем name нам повезло - для него в классе есть setter
            cat.setName("Barsik");

            Field age = clazz.getDeclaredField("age");

            age.setAccessible(true);

            age.set(cat, 6);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return cat;
    }

    public static void main(String[] args) {
        System.out.println(createCat());
    }
}