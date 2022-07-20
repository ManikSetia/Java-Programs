/*

Given two sorted integer arrays, `X[]` and `Y[]` of size `m` and `n` each, in-place merge elements of `X[]` with elements of array `Y[]` by maintaining the sorted order, i.e., fill `X[]` with the first `m` smallest elements and fill `Y[]` with remaining elements.

Input :

X[] = [1, 4, 7, 8, 10]
Y[] = [2, 3, 9]

Output:

X[] = [1, 2, 3, 4, 7]
Y[] = [8, 9, 10]

*/

package Programs.Arrays.Part2;

import java.util.Arrays;

public class MergeSortedArrays2 {
    
    //T.C. : O(m+n)log(m+n)
    //S.C. : O(m+n)
    public static void merge(int[] nums1, int[] nums2){
        //Approach1: Use extra array to store the elements
        int m=nums1.length, n=nums2.length;
        int[] result=new int[m+n];
        int i=0, k=0, j=0;
        while(i<m) result[k++]=nums1[i++];
        while(j<n) result[k++]=nums2[j++];
        Arrays.sort(result);

        //copying the elements to original Arrays
        k=i=0;
        while(i<m) nums1[i++]=result[k++];
        i=0;
        while(i<n) nums2[i++]=result[k++];
    }

    public static void mergeBetter(int[] nums1, int[] nums2){

    }


    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 8, 10};
        int[] nums2 = {2, 3, 9};
//        merge(nums1, nums2);
        mergeBetter(nums1, nums2);
        System.out.println("After sorting, num1: "+Arrays.toString(nums1));
        System.out.println("After sorting, num1: "+Arrays.toString(nums2));
    }    
}
