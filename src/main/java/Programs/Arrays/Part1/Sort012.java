//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//        You must solve this problem without using the library's sort function.

package Programs.Arrays.Part1;

import java.util.Arrays;

public class Sort012 {

    public void sortColors(int[] nums){

        //Approach1: Sorting, T.C. O(nlogn), S.C O(1)
//        Arrays.sort(nums);

        //Approach2: Counting Sort T.C. O(n) S.C O(1)
//        int countZero=0, countOne=0, countTwo=0;
//
//        for(int number=0; number<nums.length; number++){
//            if(nums[number] == 0) countZero++;
//            else if(nums[number]==1) countOne++;
//            else countTwo++;
//        }
//
//        for(int i=0; i<countZero; i++){
//            nums[i]=0;
//        }
//
//        for(int i=countZero; i<countOne+countZero; i++){
//            nums[i]=1;
//        }
//
//        for(int i=countOne+countZero; i<nums.length; i++){
//            nums[i]=2;
//        }


        //Approach3: In place T.C O(n) S.C O(1)
        //Dutch National Flag Algorithm
        int zero=0, one=0, two=nums.length-1;

        while(one<=two){
            if(nums[one]==2){
                swap(nums, one, two--);
            }
            else if(nums[one]==0){
                swap(nums, one++, zero++);
            }
            else one++;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        System.out.println("Before: "+ Arrays.toString(nums));
        Sort012 obj=new Sort012();
        obj.sortColors(nums);
        System.out.println("After: "+Arrays.toString(nums));
    }
}
