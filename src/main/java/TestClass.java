//interface NestedInterface {
//
//    interface NestedInterface2{
//        void display();
//    }
//}
//
//public class TestClass implements NestedInterface.NestedInterface2{
//    public void display(){
//        System.out.println("Helloo...");
//    }
//
//    public static void main(String[] args) {
//        NestedInterface.NestedInterface2 obj=new TestClass();//upcasting
//        obj.display();
//    }
//}

import java.io.IOException;

class OuterClass{
    interface NestedInterface{
        void display();
    }
}

public class TestClass implements OuterClass.NestedInterface{
    public void display(){
        System.out.println("Hello");
    }

    public static void main(String[] args) throws IOException {
//        OuterClass.NestedInterface obj=new TestClass();
//        obj.display();

//        Runtime.getRuntime().exec("notepad");

        System.out.println("Total memory: "+Runtime.getRuntime().totalMemory());
        System.out.println("Free memory: "+Runtime.getRuntime().freeMemory());
        
        for(int i=0; i<1000000; i++){
            new TestClass();
        }

        System.out.println("Now, free memory: "+Runtime.getRuntime().freeMemory());
        System.gc();
        System.out.println("Cleaning, free memory: "+Runtime.getRuntime().freeMemory());
    }
}