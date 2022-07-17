public class FibonacciRecursion {

    //iterative
//    public static void getFibonacci(int number){
//        System.out.print(0+" "+1+" ");
//        int first=0;
//        int second=1;
//
//        while(number-2>0){
//            int third=first+second;
//            System.out.print(third+" ");
//            first=second;
//            second=third;
//            number--;
//        }
//    }

    //recursive
    public static int getFibonacci(int number){
        if(number==0) return 0;
        else if(number==1) return 1;
        else{
            return getFibonacci(number-1)+getFibonacci(number-2);
        }
    }

    public static void main(String[] args) {
        int n=5;
//        System.out.println("Fibonacci of "+n+": ");
//        getFibonacci(n);

        System.out.println("Fibonacci of "+n+": "+getFibonacci(n));
        for(int i=0; i<n; i++) System.out.print(getFibonacci(i)+" ");
    }
}
