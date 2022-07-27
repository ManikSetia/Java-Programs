package Programs.Arrays.Part3;

public class ReversePairs {

    private static int reversePairs(int[] nums){
        if(nums==null || nums.length==0) return -1;
        int count=0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                long temp1=nums[j];
                if(nums[i]>2*temp1) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int result=reversePairs(nums);
        System.out.println(result);
    }
}
