package ReflectionAPI.InvokeFieldsAndMethods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class InvokeMethod {

    public static void invokeSayMeowMethod()  {

        Class clazz = null;
        Cat cat = null;
        try {

            cat = new Cat("Barsik", 6);

            clazz = Class.forName(Cat.class.getName());

            Method sayMeow = clazz.getDeclaredMethod("sayMeow");

            sayMeow.setAccessible(true);

            sayMeow.invoke(cat);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        invokeSayMeowMethod();
    }
}