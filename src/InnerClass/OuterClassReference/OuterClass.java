package InnerClass.OuterClassReference;

public class OuterClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        OuterClass outerClass1 = innerClass.getOuterClass();
        System.out.println(outerClass == outerClass1);
    }

    class InnerClass{
        OuterClass getOuterClass() {
            return OuterClass.this;
        }
    }
}
