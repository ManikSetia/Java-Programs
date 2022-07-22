package Programs.Arrays.Part2;

public class CountInversions {

    //T.C. : O(n2)
    //S.C. : O(1)
    public static int getInversions(int[] arr, int n){
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]) count++;
            }
        }
        return count;
    }

    //T.C. : O(nlogn)
    //S.C. : O(n)
    public static int mergeSortVariation(int[] arr, int low, int high){
        int countInversions=0;

        if(low<high){
            int mid=low+(high-low)/2;
            countInversions += mergeSortVariation(arr, low, mid);
            countInversions += mergeSortVariation(arr, mid+1, high);
            countInversions += merge(arr, low, mid, high);
        }

        return countInversions;
    }

    private static int merge(int[] arr, int low, int mid, int high){
        int i=low, j=mid+1, k=low;
        int countInversions=0;
        int[] result=new int[arr.length];

        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]) result[k++]=arr[i++];
            else{
                //required condition
                countInversions += (mid+1-i);//count all the elements of the left side as the left array is sorted
                result[k++]=arr[j++];
            }
        }

        while(i<=mid) result[k++]=arr[i++];
        while(j<=high) result[k++]=arr[j++];

        for(k=low; k<=high; k++) arr[k]=result[k];
        return countInversions;
    }

    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
//        int count=getInversions(arr, arr.length);
        int count=mergeSortVariation(arr, 0, arr.length-1);
        System.out.println("Inversions count: "+count);
    }
}
