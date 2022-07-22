package Programs.Arrays.Part0;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr, int low, int high){
        //only runs if array has atleast 2 elements
        if(low<high){
            int pivot=partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot=arr[low];
        int i=low, j=high;
        while(i<j){
            //until elements at low are smaller than the pivot, move it rightwards
            while(i<high && arr[i]<=pivot) i++;//i<high is IMPORTANT because if pivot is the largest element then i will keep on incrementing and might result in ArraysIndexOutOfBounds exception. The same thing is not required in the below loop as j can never go less than i.
            //until elements at high are bigger than the pivot, move it leftwards
            while(arr[j]>pivot) j--;
            //Now low is at that element which is bigger than pivot and high is at that element which is smaller than pivot. Now, swap them.
            if(i<j) swap(arr, i, j);
        }
        //Now place the pivot at the correct position
        swap(arr, j, low);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={4, 1, 9, 2, 3, 6};
        System.out.println("Before: "+ Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("After: "+Arrays.toString(arr));
    }
}
