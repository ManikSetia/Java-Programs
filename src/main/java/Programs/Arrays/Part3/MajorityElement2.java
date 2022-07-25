//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

package Programs.Arrays.Part3;

import java.util.*;

public class MajorityElement2 {

    private static List<Integer> majorityElement(int[] nums){
        if(nums==null || nums.length==0) return null;
//        Set<Integer> set=new HashSet<>();
//        for(int i=0; i<nums.length; i++){
//            int count=0;
//            for(int j=0; j<nums.length; j++){
//                if(nums[i]==nums[j]) count++;
//            }
//            if(count>nums.length/3) set.add(nums[i]);
//        }
//        List<Integer> result=new ArrayList<>(set);
//
//        return result;


        //T.C. : O(n)
        //S.C. : O(n)
//        List<Integer> result=new ArrayList<>();
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int ele: nums){
//            map.put(ele, map.getOrDefault(ele, 0)+1);
//        }
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//            if(entry.getValue()>nums.length/3) result.add(entry.getKey());
//        }
//        return result;


        List<Integer> result=new ArrayList<>();
        int num1=-1, num2=-1;
        int count1=0, count2=0;

        for(int ele: nums){
            if(ele==num1) count1++;
            else if(ele==num2) count2++;
            else if(count1==0){
                num1=ele;
                count1=1;
            }
            else if(count2==0){
                num2=ele;
                count2=1;
            }

            else{
                count1--;
                count2--;
            }
        }

        //Since it's not mentioned that majority elements exist everytime. So, we've to add one more check.
        count1=count2=0;
        for(int ele: nums){
            if(ele==num1) count1++;
            else if(ele==num2) count2++;
        }
        if(count1>nums.length/3) result.add(num1);
        if(count2>nums.length/3) result.add(num2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums={2,1,1,3,1,4,5,6};
        List<Integer> result=majorityElement(nums);
        System.out.println(result);
    }
}
