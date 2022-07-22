package Programs.Arrays.Part0;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] arr, int low, int high){
        //Continue if array contains minimum 2 elements
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high){
        //Create dummy array for copying the elements
        int[] result=new int[arr.length];
        int i=low, j=mid+1, k=low;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]) result[k++]=arr[i++];
            else result[k++]=arr[j++];
        }

        //if one of the pointer reaches to the end than copy the array which is left as it is.
        if(i>mid){
            //copy second array
            while(j<=high) result[k++]=arr[j++];
        }
        else {
            //copy the first array
            while(i<=mid) result[k++]=arr[i++];
        }

        //copy the values from the dummy array to the original array
        for(k=low; k<=high; k++) arr[k]=result[k];
    }

    public static void main(String[] args) {
        int[] arr={4, 1, 9, 2, 3, 6};
        System.out.println("Before: "+ Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("After: "+Arrays.toString(arr));
    }
}
