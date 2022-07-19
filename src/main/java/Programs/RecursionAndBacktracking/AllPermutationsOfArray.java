package Programs.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfArray {

//    public static List<List<Integer>> permute(int[] nums){
//        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> dataStructure=new ArrayList<>();//to store the elements
//        boolean[] frequency=new boolean[nums.length];//to check if the element is taken or not
//        printAllPermutations(result, dataStructure, frequency, nums);
//        return result;
//    }

    //Better Approach
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        printAllPermutationsBetter(result, nums, 0);//initially we're starting with index 0
        return result;
    }

    //T.C. : n!*n //n! for generating all permutations of array of size n and n for traversal
    //S.C. : O(1)
    private static void printAllPermutationsBetter(List<List<Integer>> answer, int[] nums, int index){
        if(index==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                list.add(nums[i]);
            }
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<nums.length; i++){
            swap(i, index, nums);
            printAllPermutationsBetter(answer, nums, index+1);
            //after returning, swap again to get back to the original position
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //T.C. : n!*n //n! for generating all permutations of array of size n and n for traversal
    //S.C. : O(n)+O(n)//for data structure and frequency
    private static void printAllPermutations(List<List<Integer>> result, List<Integer> dataStructure, boolean[] frequency, int[] nums){
        if(dataStructure.size()==nums.length){
            result.add(new ArrayList<>(dataStructure));
            return;
        }

        for(int i=0; i<nums.length; i++){
            //only add the element if it is not taken
            if(!frequency[i]){
                dataStructure.add(nums[i]);
                frequency[i]=true;
                printAllPermutations(result, dataStructure, frequency, nums);
                //Now is the step to remove the element from ds and set frequency to false before the next recursive call
                dataStructure.remove(dataStructure.size()-1);//removing the last added element
                frequency[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1, 2, 3};
        List<List<Integer>> result=permute(nums);
        System.out.println(result);
    }
}
