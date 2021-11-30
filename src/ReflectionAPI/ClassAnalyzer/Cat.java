package ReflectionAPI.ClassAnalyzer;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void sayMeow() {

        System.out.println("Meow!");
    }

    public void jump() {

        System.out.println("Jump!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}