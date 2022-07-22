package Programs.Arrays.Part0;

public class BinarySearch {

    private static int binarySearchIterative(int[] arr, int search){
        int low=0, high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(search>arr[mid]){
                //element is at right side
                low=mid+1;
            }
            else if(search<arr[mid]){
                //left side
                high=mid-1;
            }
            else if(search==arr[mid]) return mid;
        }

        return -1;
    }


    //Auxiliary space : O(logn)
    public static int binarySearchRecursive(int[] arr, int low, int high, int search){
        int mid=low+(high-low)/2;
        if(low>high) return -1;
        else if(search>arr[mid]){
            return binarySearchRecursive(arr, mid+1, high, search);
        }
        else if(search<arr[mid]){
            return binarySearchRecursive(arr, low, mid-1, search);
        }
        return mid;



    }

    public static void main(String[] args) {
        int[] arr={-4,-1,3,7,10,11};
        int search=-43;
//        System.out.println(search+" is at "+binarySearchIterative(arr, search));
        System.out.println(search+" is at "+binarySearchRecursive(arr, 0, arr.length-1, search));
    }
}
