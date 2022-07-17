public class FactorialRecursion {

    public static int getFactorial(int number){
        if(number==1) return 1;
        return number*getFactorial(number-1);
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println("Factorial of "+n+": "+getFactorial(n));
    }
}
