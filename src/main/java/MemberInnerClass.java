public class MemberInnerClass {

    private int data=50;
    private static int value=150;
    class InnerClass{
        void display(){
            System.out.println("data: "+data);
            System.out.println("value: "+value);
        }
    }

    public static void main(String[] args) {
        MemberInnerClass outerObj=new MemberInnerClass();
        MemberInnerClass.InnerClass innerObj=outerObj.new InnerClass();
        innerObj.display();
    }
}
