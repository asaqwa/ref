package ReflectionAPI.GetNewInstance;

import java.lang.reflect.InvocationTargetException;


public class ObjCreatorConstructorWithArgs {

        public static Cat createCat()  {

            Class clazz = null;
            Cat cat = null;

            try {
                clazz = Class.forName("ReflectionAPI.GetNewInstance.Cat");
                Class[] catClassParams = {String.class, int.class};
                cat = (Cat) clazz.getConstructor(catClassParams).newInstance("Barsik", 6);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            return cat;
        }

        public static void main(String[] args) {
            System.out.println(createCat());
        }
    }