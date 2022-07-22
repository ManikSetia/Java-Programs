package Programs.Arrays.Part0;

import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void bubbleSort(int[] arr, int n){
        for(int i=0; i<n-1; i++){//in worst case, loop will runs n-1 times.
            boolean swapped=false;//check if array gets sorted before the final iteration or array is already sorted
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>=arr[j+1]) {
                    swapped=true;
                    swap(arr, j, j+1);
                }
            }
            if(!swapped){
                //means we didn't do swapping
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={5,2,8,6,1};
        System.out.println("Before: "+ Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println("After: "+Arrays.toString(arr));
    }
}
