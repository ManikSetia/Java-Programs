//private static boolean isEmpty(String s){
//        for(int i=0; i<s.length(); i++){
//        if(s.charAt(i)==' ') return true;
//        }
//        return false;
//        }
//public int lengthOfLongestSubstring(String s) {
        // if(isEmpty(s)) return 1;

        //Approach1: Generate all substrings
//         int res=0;

//         for(int i=0; i<s.length(); i++){
//             for(int j=i; j<s.length(); j++){
//                 if(isUnique(s, i, j)) res=Math.max(res, j-i+1);
//             }
//         }

//         return res;


        //Approach2
//         Set<Character> set=new HashSet<>();
//         int left=0, right=0;
//         char[] arr=s.toCharArray();

//         int len=0;

//         while(right<arr.length && left<=right){

//             if(!set.contains(arr[right])){
//                 //unique element
//                 int newLen=right-left+1;
//                 if(len<newLen){
//                     len=newLen;
//                 }
//                 set.add(arr[right]);
//                 right++;
//             }
//             else{
//                 //set contains the element. Loop until we remove that element
//                 while(set.contains(arr[right])){
//                     set.remove(arr[left]);
//                     left++;
//                 }
//                 //element has been removed
//                 set.add(arr[right]);
//                 right++;
//             }
//         }

//         return len;


//        //Optimal
//        int len=0;
//        Map<Character, Integer> map=new HashMap<>();
//
//        char[] arr=s.toCharArray();
//
//        int left=0, right=0;
//
//        while(right<arr.length && left<=right){
//
//        if(map.containsKey(arr[right])){
//        int prevIndex=map.get(arr[right]);
//        if(left<=prevIndex) left=prevIndex+1;
//        }
//
//        int minLen=right-left+1;
//        len=(len<minLen)?minLen:len;
//
//        map.put(arr[right], right);
//        right++;
//        }
//
//        return len;
//        }
//
//private static boolean isUnique(String  s, int i, int j){
//        boolean[] visited=new boolean[26];
//
//        for(int k=i; k<=j; k++){
//        int index=s.charAt(k)-'a';
//        if(visited[index]) return false;
//        visited[index]=true;
//        }
//
//        return true;
//        }


package Programs.Arrays.Part4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    private static boolean isUnique(String s, int i, int j){
        boolean[] visited=new boolean[26];
        for(int k=i; k<=j; k++){
            int index=s.charAt(k)-'a';
            if(visited[index]) return false;
            visited[index]=true;
        }
        return true;
    }

   //Approach1: Generate all substrings
    public static int lengthOfLongestSubstring(String s){
        int maxLen=0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                //need to check string consists of unique characters or not
                if(isUnique(s, i, j)){
                    int len=j-i+1;
                    maxLen=maxLen<len?len:maxLen;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        int result=lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
