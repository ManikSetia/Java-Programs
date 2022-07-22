//In this problem, we can't use arr.length as array is of infinite length.

package Programs.Arrays.Part0;

public class FindElementInInfiniteSortedArray {

    private static int findElement(int[] arr, int search){
        int low=0;
        int high=1;
        while(search>arr[high]){
            low=high;
            high *= 2;//exponentiation, responsible for logn complexity
        }
        //Now element to be searched is in our range. That means we can apply standard binary search now.
        return binarySearch(arr, search, low, high);
    }

    private static int binarySearch(int[] arr, int search, int low, int high){
        int mid=low+(high-low)/2;
        if(low>high) return -1;
        if(search>arr[mid]) return binarySearch(arr, search, mid+1, high);
        if(search<arr[mid]) return binarySearch(arr, search, low, mid-1);
        return mid;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        int search=49;
        System.out.println(search+" is at "+findElement(arr, search));
    }
}
