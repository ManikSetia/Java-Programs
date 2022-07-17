public class StaticNestedClass {
    private static int value=10;

//    static class NestedClass{
//        void display(){
//            System.out.println("value: "+value);
//        }
//    }

    static class NestedClass{
        static void display(){
            System.out.println("value: "+value);
        }
    }

    public static void main(String[] args) {
//        StaticNestedClass.NestedClass obj=new StaticNestedClass.NestedClass();
//        obj.display();

        StaticNestedClass.NestedClass.display();
    }
}
