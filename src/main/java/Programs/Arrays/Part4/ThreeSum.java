package Programs.Arrays.Part4;

import java.util.*;

public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> set=new HashSet<>();
        List<Integer> list=null;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                    }
                }
                set.add(list);
            }
        }
        if(set.contains(null)) set.remove(null);

        List<List<Integer>> result=new ArrayList<>(set);

        return result;
    }



    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
//        List<List<Integer>> result=threeSum(nums);
        List<List<Integer>> result=threeSumBetter(nums);
        System.out.println(result);
    }
}
