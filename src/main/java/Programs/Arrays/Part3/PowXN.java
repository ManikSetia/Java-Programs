package Programs.Arrays.Part3;

public class PowXN {

    private static double myPow(double x, int n){
//        double result=1;
//        long m=n;//It is done to prevent overflow. Consider n is the minimum value of integer, i.e. -2,147,483,648 and if convert into positive integer, it'll be 2,147,483,648 but maximum value of integer can only be 2,147,483,647. That's why, we're converting into long.
//        for(int i=0; i<Math.abs(m); i++){
//            result *= x;
//        }
//        if(n>0) return result;
//        return 1/result;


        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        double x=2.00000;
        int n=-2147483648;
        double result=myPow(x, n);
        System.out.println(x+" to the power "+n+": "+result);
    }
}
