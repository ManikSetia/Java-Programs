public class Test {

    public static void main(String[] args) {
        Test obj=new Test();
        System.out.println("Hashcode is: " + obj.hashCode());
        obj = null;
        // calling the garbage collector using gc()
        System.gc();
        System.out.println("End of the garbage collection");
    }
    protected void finalize(){
        System.out.println("finalize called");
    }
}
