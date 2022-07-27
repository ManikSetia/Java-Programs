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

    //T.C. : O(n2logm)//logm is insertion time for set
    //S.C. : O(m)+O(n)//for set and map
    private static List<List<Integer>> threeSumBetter(int[] nums){
        Set<List<Integer>> set=new HashSet<>();
        List<Integer> list=null;
        Map<Integer, Integer> map=new HashMap<>();

        for(int ele: nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int i=0; i<nums.length; i++){

            //Now, if we're taking nums[i] then we can't use it in the hash map for searching as it'll be exhausted. So, we've to decrease the occurrence in the hash map of current element by 1.
            map.put(nums[i], map.get(nums[i])-1);

            for(int j=i+1; j<nums.length; j++){

                //Again same thing as above
                map.put(nums[i], map.get(nums[j])-1);

                int target=-(nums[i]+nums[j]);
                if(map.containsKey(target) && map.get(target)>0){
                    list=new ArrayList<>();
                    list.add(target);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    Collections.sort(list);//so that we can get unique elements
                }

                map.put(nums[i], map.get(nums[j])+1);//putting back the occurrence
            }

            set.add(list);

            map.put(nums[i], map.get(nums[i])+1);
        }

        List<List<Integer>> result=new ArrayList<>(set);

        return result;
    }

    //Two pointer
    //T.C. : O(n2)
    //S.C. : O(1)
    private static List<List<Integer>> threeSumOptimal(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int low=i+1, high=nums.length-1;
            int target=-nums[i];

            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                while(low<high){
                    int sum=nums[low]+nums[high];
                    if(sum<target) low++;
                    else if(sum>target) high--;
                    else{
                        //we found the triplet
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        //Now is the trick part
                        //Since we've sorted the array and if the array contains duplicate elements then those elements will be together in the array. And we want unique triplets so we don't want to store them.
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;

                        low++;
                        high--;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
//        List<List<Integer>> result=threeSum(nums);
//        List<List<Integer>> result=threeSumBetter(nums);
        List<List<Integer>> result=threeSumOptimal(nums);
        System.out.println(result);
    }
}
