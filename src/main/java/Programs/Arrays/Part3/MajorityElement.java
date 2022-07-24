package Programs.Arrays.Part3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    //T.C. : O(n2)
    //S.C. : O(1)
    private static int majorityElement(int[] arr){
        for(int i=0; i<arr.length; i++){
            int count=0;
            for(int j=0; j<arr.length; j++){
                if(arr[i]==arr[j]) count++;
            }
            if(count>arr.length/2) return arr[i];
        }
        return -1;
    }

    //T.C. : O(n)
    //S.C. : O(n)
    private static int majorityElementBetter(int[] arr){
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>arr.length/2) return entry.getKey();
        }
        return -1;
    }

    //T.C. : O(n)
    //S.C. : O(1)
    private static int majorityElementOptimal(int[] arr){
        int majorityElement=0;
        int count=0;
        for(int i=0; i<arr.length; i++){
            if(count==0) {
                majorityElement = arr[i];
            }
            if(majorityElement==arr[i]) count++;
            else count--;
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] arr={2,2,1,1,1,2,2};
//        int element=majorityElement(arr);
//        int element=majorityElementBetter(arr);
        int element=majorityElementOptimal(arr);
        System.out.println("Majority element: "+element);
    }
}
