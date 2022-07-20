//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

package Programs.Arrays.Part2;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void mergeBrute(int[] nums1, int m, int[] nums2, int n){
        int[] result=new int[m];
        int i=0, k=0, j=0;
        while(i<m && nums1[i]!=0){
            result[k++]=nums1[i++];
        }
        while(j<n){
            result[k++]=nums2[j++];
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int[] result=new int[m];
        if(m==1 && n==0) result[0]=nums1[0];
        int i=0, j=0, k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j] && nums1[i]!=0) result[k++]=nums1[i++];
            else result[k++]=nums2[j++];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void mergeBetter(int[] nums1, int m, int[] nums2, int n){
        int i=m-1, j=n-1, k=m-1;
        if(m==1 && n==1) nums1[0]=nums2[0];
        while(i>=0 && nums1[i] == 0) i--;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]) nums1[k--]=nums1[i--];
            else nums1[k--]=nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1={0};
        int[] nums2={1};
//        merge(nums1, nums1.length, nums2, nums2.length);
//        mergeBetter(nums1, nums1.length, nums2, nums2.length);
        mergeBrute(nums1, nums1.length, nums2, nums2.length);
    }
}
