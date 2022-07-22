package Programs.Arrays.Part0;

import java.util.Arrays;

public class SelectionSort {

    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //T.C. : O(n2)
    private static void selectionSort(int[] arr, int n){
        for(int i=0; i<n-1; i++){
            int minIndex=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                //then do swap because if minIndex==i, then there is no need to do swapping
                swap(arr, minIndex, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={4,1,9,2,3,6};
        System.out.println("Before: "+ Arrays.toString(arr));
        selectionSort(arr, arr.length);
        System.out.println("After: "+Arrays.toString(arr));
    }
}
