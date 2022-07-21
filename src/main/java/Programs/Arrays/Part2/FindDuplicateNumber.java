package Programs.Arrays.Part2;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateNumber {

    //T.C. : O(n2)
    //S.C. : O(1)
    //or we can use sorting as well
    public static int findDuplicate(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i!=j && nums[i]==nums[j]) return nums[i];
            }
        }
        return -1;
    }


    //T.C. : O(n)
    //S.C. : O(n)
    public static int findDuplicateBetter(int[] nums){
        Map<Integer, Integer> map=new HashMap<>();
        for(int number: nums){
            map.put(number, map.getOrDefault(number, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>1) return entry.getKey();
        }
        return -1;
    }

    //T.C. : O(n)
    //S.C. : O(1)
    public static int findDuplicateOptimal(int[] nums){
        int n=nums.length;
        int duplicateElement=-1;
        for(int i=0; i<n; i++) nums[i]--;

        for(int i=0; i<n; i++){
            nums[nums[i]%n]=nums[nums[i]%n]+n;
        }

        for(int i=0; i<n; i++){
            if(nums[i]/n>=2){
                duplicateElement=i+1;
            }
        }

        return duplicateElement;
    }

    //Negative marking
    //T.C. : O(n)
    //S.C. : O(1)
    public static int findDuplicateOptimal2(int[] nums){
        int duplicate=-1;
        for(int i=0; i<nums.length; i++){
            int index=Math.abs(nums[i]);
            if(nums[index]<0) {
                duplicate=index;
                break;
            }
            nums[index] *= -1;
        }

        //restoring elements
        for(int i=0; i<nums.length; i++) nums[i]=Math.abs(nums[i]);
        return duplicate;
    }

    public static void main(String[] args) {
        int[] nums={3,1,3,4,2};
//        int duplicateNumber=findDuplicate(nums);
//        int duplicateNumber=findDuplicateBetter(nums);
        int duplicateNumber=findDuplicateOptimal2(nums);
        System.out.println("Duplicate number: "+duplicateNumber);
    }
}
