package Programs.Arrays.Part4;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayZeroSum  {

    public int maxLen(int arr[], int n) {
        //Approach1: loop over every subarray and find sum

        //Approach2
        if(arr==null || n==0) return 0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0, maxLen=0, len=0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            else{
                int index=map.get(sum);
                len=i-index;
            }
            maxLen=(len>maxLen)?len:maxLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums={15,-2,2,-8,1,7,10,23};
        int max=new LargestSubarrayZeroSum().maxLen(nums, nums.length);
        System.out.println(max);
    }
}
