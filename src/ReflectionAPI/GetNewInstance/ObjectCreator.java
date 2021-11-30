package ReflectionAPI.GetNewInstance;

public class ObjectCreator {

    public static Cat createCat(Cat cat) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class clazz = Class.forName(cat.getClass().getName());
        return (Cat) clazz.newInstance();
    }

    public static Object createObject(Object o) throws Exception {
        Class clazz = Class.forName(o.getClass().getName());

        return clazz.newInstance();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(createCat(new Cat("Tom", 3)));
        System.out.println(createObject(new Cat()));
    }
}