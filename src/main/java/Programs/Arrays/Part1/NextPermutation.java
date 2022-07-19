package Programs.Arrays.Part1;

import java.util.Arrays;

public class NextPermutation {

    //Brute approach is first find all the permutations and then find the next permutation from the list

    //T.C. : O(n)+O(n)+O(n)
    //S.C. : O(1)
    public static void nextPermutation(int[] nums){
        if(nums==null || nums.length<=1) return;
        //Step1: Find the breakpoint i.e. smallest number from the back
//        int minIndex=nums.length-1;
//        int min=nums[minIndex];
//        for(int i=nums.length-2; i>=0; i--){
//            if(nums[i]<min){
//                min=nums[i];
//                minIndex=i;
//                break;
//            }
//        }
//
//        //Step2: Find the number greater than our minimum from the back
//        int justGreaterIndex=nums.length-1;
//        int justGreater=nums[justGreaterIndex];
//        for(int i=nums.length-1; i>=0; i--){
//            if(justGreater>min) {
//                justGreater=nums[i];
//                justGreaterIndex=i;
//                break;
//            }
//        }
//
//        //Step3: Swap the two found numbers i.e. min with the justGreater number
//        swap(minIndex, justGreaterIndex, nums);
//
//        //Step4: Reverse the part from the next index of min to the end of the array
//        reverse(nums, minIndex+1);


        //More refined code
        int i=nums.length-2;
        //loop until we find the breakpoint from the end
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        //Now i is at smallest number from behind if exists
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]) j--;
            //Now j is at index which is greater than our number found in first step
            swap(i, j, nums);
        }
        reverse(i+1, nums.length-1, nums);
    }

    private static void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private static void reverse(int i, int j, int[] nums){
        while(i<j){
            swap(i++, j--, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums={3, 2, 1};
        System.out.println("Current: "+ Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next: "+Arrays.toString(nums));
    }
}
