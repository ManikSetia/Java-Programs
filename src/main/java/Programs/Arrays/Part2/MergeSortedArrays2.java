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

    //Approach2: Kind of Insertion sort
    //S.C. : O(1)
    //T.C. : O(m*n) //O(m) for traversal of nums1 and O(n) for reordering of nums2
    public static void mergeBetter(int[] nums1, int[] nums2){
        int i=0, j=0;
        int m=nums1.length, n=nums2.length;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]) i++;
            else{
                int temp=nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=temp;

                //Now, we've to reorder the elements in nums2
                int first=nums2[0];
                int k;
                for(k=1; k<n && nums2[k]<first; k++){
                    nums2[k-1]=nums2[k];
                }
                nums2[k-1]=first;
            }
        }
    }

    //GAP method (kind of shell sorting)
    public static void mergeOptimal(int[] nums1, int[] nums2){


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 8, 10};
        int[] nums2 = {2, 3, 9};
//        merge(nums1, nums2);
//        mergeBetter(nums1, nums2);
        mergeOptimal(nums1, nums2);
        System.out.println("After sorting, num1: "+Arrays.toString(nums1));
        System.out.println("After sorting, num1: "+Arrays.toString(nums2));
    }    
}
