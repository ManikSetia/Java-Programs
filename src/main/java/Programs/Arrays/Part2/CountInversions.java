package Programs.Arrays.Part2;

public class CountInversions {

    //T.C. : O(n2)
    //S.C. : O(1)
    public static long getInversions(long[] arr, int n){
        long count=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        long[] arr={3,2,1};
        long count=getInversions(arr, arr.length);
        System.out.println("Inversions count: "+count);
    }
}
