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
    //T.C. : O(n3logn)
    //S.C. : O(n)
    private static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<Integer> list=null;
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    list=new ArrayList<>();
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[k];

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

    private static int binarySearch(int[] nums, int i, long search){
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

    //Approach is we'll use two pointers (2 Nested loops) for first two elements and then we'll iterate over rest of the array for (-sum of first two elements)
    //T.C. : O(n3)
    //S.C. : O(1)
    private static List<List<Integer>> fourSumBetter(int[] nums, int target){
        List<List<Integer>> result=new ArrayList<>();

        if(nums==null || nums.length==0) return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){

                for(int j=i+1; j<nums.length; j++){
                    long sum1=(long)nums[i]+(long)nums[j];

                    int low=j+1, high=nums.length-1;


                    while(low<high){
                        long sum2=(long)nums[low]+(long)nums[high];

                        if(sum2>target-sum1) high--;
                        else if(sum2<target-sum1) low++;
                        else{
                            result.add(Arrays.asList(nums[low], nums[high], nums[i], nums[j]));

                            //to avoid duplicates
                            while(low<high && nums[low]==nums[low+1]) low++;
                            while(low<high && nums[high]==nums[high-1]) high--;

                            low++; high--;
                        }
                    }

                    //to avoid duplicates
                    while(j<nums.length-1 && nums[j]==nums[j+1]) j++;

                }

                //to avoid duplicates
                while(i< nums.length-1 && nums[i]==nums[i+1]) i++;


        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
//        List<List<Integer>> list=fourSum(nums, 8);
        List<List<Integer>> list=fourSumBetter(nums, -294967296);
        System.out.println(list);
    }
}
