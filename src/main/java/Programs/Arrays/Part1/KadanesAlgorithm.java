package Programs.Arrays.Part1;

public class KadanesAlgorithm {

    public static int maxSubArray(int[] arr){

        //Approach 1
//        int max=Integer.MIN_VALUE;
//        for(int i=0; i<arr.length; i++){
//            for(int j=i; j<arr.length; j++){
//                //to calculate sum from i to j
//                int sum=0;
//                for(int k=i; k<=j; k++){
//                    sum += arr[k];
//                }
//                max=(sum>max)?sum:max;
//            }
//        }
//        return max;

        //Approach 2
//        int max=Integer.MIN_VALUE;
//        for(int i=0; i<arr.length; i++){
//            int sum=0;
//            for(int j=i; j<arr.length; j++){
//                sum += arr[j];
//                max=(sum>max)?sum:max;
//            }
//
//        }
//        return max;

        //Approach 3: Kadane's algorithm
        int sum=0;
        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            max=(sum>max)?sum:max;
            if(sum<0) sum=0;//as we want the maximum sum
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={5,4,-1,7,8};
        int max=maxSubArray(nums);
        System.out.println("Maximum sum: "+max);
    }
}
