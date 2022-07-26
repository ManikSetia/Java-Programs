package Programs.Arrays.Part3;

public class SearchInA2DMatrix {

    private static boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null || matrix.length==0) return false;
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[0].length; j++){
//                if(matrix[i][j]==target) return true;
//            }
//        }
//        return false;

        //O(n*logm)
//        for(int i=0; i<matrix.length; i++){
//            if(binarySearch(matrix[i], 0, matrix[0].length-1, target)) return true;
//        }
//        return false;

        //O(m+n)
        //Approach 3: Pick top right element and start comparing with the target because from the top right if you go to the left, elements st art decreasing and if you go to the down, elements start increasing.
        int i=0, j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]>target) j--;
            else i++;
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target) return true;
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        boolean result=searchMatrix(matrix, 23);
        System.out.println(result);
    }
}
