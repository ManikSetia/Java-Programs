package Programs.Arrays.Part4;

import java.util.*;

public class FourSum {

//    private static List<List<Integer>> fourSum(int[] nums, int target){
//        List<List<Integer>> result=new ArrayList<>();
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length; j++){
//                for(int k=j+1; k<nums.length; k++){
//                    List<Integer> list=new ArrayList<>();
//                    for(int l=k+1; l<nums.length; l++){
//                        if(nums[i]+nums[j]+nums[k]+nums[l]==target){
//                            list.add(nums[i]);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            list.add(nums[l]);
//                        }
//                    }
//                    if(!list.isEmpty()) result.add(list);
//                }
//            }
//        }
//        return result;
//    }

    //Approach is first we'll sort the array to use pointers approach. Take 3 pointers (3 nested loop) and will search for forth element in the rest of the array using Binary Search.
    private static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<Integer> list=null;
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    list=new ArrayList<>();
                    int sum=nums[i]+nums[j]+nums[k];

                    //Now we've to search for (-sum) in rest of the array. For that we're gonna use Binary Search
                    int forthElementIndex=binarySearch(nums, k+1, target-sum);
                    if(forthElementIndex != -1){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[forthElementIndex]);
                        Collections.sort(list);set.add(list);
                    }

                }

            }
        }
        if(set.contains(null)) set.remove(null);

        List<List<Integer>> result=new ArrayList<>(set);

        return result;
    }

    private static int binarySearch(int[] nums, int i, int search){
        int low=i;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>search) high--;
            else if(nums[mid]<search) low++;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,2,2};
        List<List<Integer>> list=fourSum(nums, 8);
        System.out.println(list);
    }
}
