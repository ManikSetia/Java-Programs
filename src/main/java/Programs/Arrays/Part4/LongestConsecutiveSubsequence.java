package Programs.Arrays.Part4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
//         Arrays.sort(nums);

//         int max=0, temp=0;
//         for(int i=0; i<nums.length-1; i++){
//             if(nums[i]+1==nums[i+1]){
//                 temp++;
//                 max=(temp>max)?temp:max;
//             }
//             else if(nums[i]!=nums[i+1]) temp=0;//as array can contains duplicate elements. In that case, keep the temp as it is.
//         }
//         return max+1;


//         Set<Integer> set=new TreeSet<>();
//         for(int i=0; i<nums.length; i++) set.add(nums[i]);

//         int max=0, temp=0;

//         int[] arr=new int[set.size()];
//         int j=0;
//         for(int ele: set){
//             arr[j++]=ele;
//         }

//         for(int i=0; i<arr.length-1; i++){
//             if(arr[i]+1==arr[i+1]){
//                 temp++;
//                 max=(temp>max)?temp:max;
//             }
//             else temp=0;
//         }

//         return max+1;



        Set<Integer> set=new HashSet<>();
        for(int ele: nums) set.add(ele);
        int maxStreak=0;
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int currentStreak=0;
                while(set.contains(nums[i]+1)){
                    currentStreak++;
                    nums[i]=nums[i]+1;
                }
                maxStreak=(currentStreak>maxStreak)?currentStreak:maxStreak;
            }
        }
        return maxStreak+1;
    }

    public static void main(String[] args) {
        int[] nums={100, 4, 200, 1, 3, 2};
        int max=new LongestConsecutiveSubsequence().longestConsecutive(nums);
        System.out.println(max);
    }
}
