public class LocalInnerClass {

    private int data=100;
    void msg(){
        class InnerClass{
            void display(){
                System.out.println("Data: "+data);
            }
        }

        InnerClass innerObj=new InnerClass();
        innerObj.display();
    }

    public static void main(String[] args) {
        LocalInnerClass outerObj=new LocalInnerClass();
        outerObj.msg();
    }
}
