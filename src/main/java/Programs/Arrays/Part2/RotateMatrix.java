package Programs.Arrays.Part2;

import java.util.PrimitiveIterator;

public class RotateMatrix {

    public static void rotateMatrixAntiClockwise90(int[][] matrix){
        int[][] rotatedMatrix=new int[matrix.length][matrix[0].length];

        int i=0;
        while(i<matrix.length){
            int j=0;
            while(j<matrix[0].length){
                rotatedMatrix[i][j]=matrix[j][matrix.length-1-i];
                j++;
            }
            i++;
        }

        //copying
        for(int k=0; k<matrix.length; k++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[k][j]=rotatedMatrix[k][j];
            }
        }
    }

    //T.C. : O(n2)+O(n2)
    //S.C. : O(n2)
    public static void rotateMatrixClockwise90(int[][] matrix){
        //Approach1
        int[][] rotatedMatrix=new int[matrix.length][matrix[0].length];

        int i=0;
        while(i<matrix.length){
            int j=0;
            while(j<matrix[0].length){
                rotatedMatrix[i][j]=matrix[matrix.length-1-j][i];
                j++;
            }
            i++;
        }

        //copying
        for(int k=0; k<matrix.length; k++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[k][j]=rotatedMatrix[k][j];
            }
        }
    }

    public static void print(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix={
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        System.out.println("Before rotation: ");
        print(matrix);
        rotateMatrixClockwise90(matrix);

//        rotateMatrixAntiClockwise90(matrix);
        System.out.println("After rotation: ");
        print(matrix);
    }
}

