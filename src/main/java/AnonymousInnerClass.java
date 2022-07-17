//abstract class Person{
//    abstract void eat();
//}
interface Person{
    void eat();
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
//        Person obj=new Person(){
//            void eat(){
//                System.out.println("eating");
//            };
//
//        };
//        obj.eat();

        Person interfaceVariable=new Person() {
            @Override
            public void eat() {
                System.out.println("interface, eating..");
            };
        };
        interfaceVariable.eat();
    }

}
