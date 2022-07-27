//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.


package Programs.Arrays.Part4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    private static int[] twoSumBetter(int[] nums, int target){
        int[] result=new int[2];
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,5};
//        int[] result=twoSum(nums, 6);
        int[] result=twoSumBetter(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}
