package Programs.Arrays.Part2;

public class FindDuplicateNumber {

    //T.C. : O(n2)
    //S.C. : O(1)
    public static int findDuplicate(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i!=j && nums[i]==nums[j]) return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums={1, 3, 4, 2, 2};
        int duplicateNumber=findDuplicate(nums);
        System.out.println("Duplicate number: "+duplicateNumber);
    }
}
