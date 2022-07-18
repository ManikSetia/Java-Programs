package Programs.Arrays.Part1;

public class SetMatrixZeroes {

    //Approach1: T.C:  O(m*n)*O(m+n)
    //m*n for tranversing each element
    //and m+n for updating the values in the rows and columns
    //Filling -1 by considering that matrix consists only positive elements
    public static void fillRight(int[][] matrix, int row, int column){
        for(int j=column+1; j<matrix[0].length; j++){
            //this check is made so that we don't accidently update 0 which we wanted
            if(matrix[row][j] != 0) matrix[row][j]=-1;
        }
    }

    public static void fillLeft(int[][] matrix, int row, int column){
        for(int j=0; j<column; j++){
            if(matrix[row][j] != 0) matrix[row][j]=-1;
        }
    }

    public static void fillUp(int[][] matrix, int row, int column){
        for(int i=0; i<row; i++){
            if(matrix[i][column] != 0) matrix[i][column]=-1;
        }
    }

    public static void fillDown(int[][] matrix, int row, int column){
        for(int i=row+1; i<matrix.length; i++){
            if(matrix[i][column] != 0) matrix[i][column]=-1;
        }
    }

    public static void setZeroes(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    fillRight(matrix, i, j);
                    fillLeft(matrix, i, j);
                    fillUp(matrix, i, j);
                    fillDown(matrix, i, j);
                }
            }
        }

        //Now, removing the -1 and update to 0 for final result
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==-1) matrix[i][j]=0;
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix={
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        System.out.println("Before: ");
        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("After: ");
        printMatrix(matrix);
    }
}
