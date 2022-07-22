package Programs.Arrays.Part0;

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[] arr, int n){
        for(int i=0; i<n; i++){
            int elementToBeInserted=arr[i];
            int j;
            for(j=i-1; j>=0 && arr[j]>elementToBeInserted; j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=elementToBeInserted;
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 6, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        insertionSort(arr, arr.length);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
