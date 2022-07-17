//You are given an integer N. Your task is to return a 2-D ArrayList containing the pascal’s triangle till the row N.
//        A Pascal's triangle is a triangular array constructed by summing adjacent elements in preceding rows. Pascal's triangle contains the values of the binomial coefficient. For example in the figure below.
//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1

package Programs.Arrays.Part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows){
//        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> row, pre=null;
//
//        for(int i=0; i<numRows; i++){
//            row=new ArrayList<>();
//            //number of columns equal to number of rows
//            for(int j=0; j<=i; j++){
//                //first and last column has 1
//                if(j==0 || j==i) row.add(1);
//                else{
//                    row.add(pre.get(j-1)+pre.get(j));
//                }
//            }
//            pre=row;
//            result.add(row);
//        }


        //First add 1 in the beginning of the row and then do the add operation and then perform deep copy and the same row is passed to the next iteration.

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> row=new ArrayList<>();

        for(int i=0; i<numRows; i++){
            row.add(0, 1);
            //number of columns equal to number of rows
            for(int j=1; j<i; j++){
                row.set(j, row.get(j)+row.get(j+1));
            }
            result.add(new ArrayList<>(row));//deep copy
        }

        return result;
    }

    //return row corresponding to rowIndex
    public static List<Integer> getRow(int rowIndex){
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] += arr[j - 1];
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int a : arr){
            res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        int n=4;
//        List<List<Integer>> result=generate(n);
//        System.out.println(result);
        List<Integer> row=getRow(3);
        System.out.println(row);
    }
}
