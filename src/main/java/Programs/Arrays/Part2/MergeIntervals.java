//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

//Example :
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].


package Programs.Arrays.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    //T.C. : O(nlogn)
    private static int[][] merge(int[][] intervals){
        //base cases
        if(intervals==null || intervals.length==0) return new int[0][];

        //First step: Sorting so that we can make comparisons
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        ArrayList<int[]> list=new ArrayList<>();//dummy list

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int[] array: intervals){
            if(end>=array[0]) {
                //update end as array is sorted based on first index. So, no need to consider first index.
                end=Math.max(end, array[1]);
            }
            else{
                //add the array into the dummy list and update the start and end
                list.add(new int[]{start, end});
                start=array[0];
                end=array[1];
            }
        }
        //Add the last array into the list as well.
        list.add(new int[]{start, end});

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr={
                {1, 3},
                {8, 10},
                {2, 6},
                {15, 18}
        };
        System.out.println("Before: ");
        print(arr);
        int[][] result=merge(arr);
        System.out.println("After: ");
        print(result);
    }

    private static void print(int[][] intervals){
        for(int i=0; i<intervals.length; i++){
            for(int j=0; j<intervals[0].length; j++){
                System.out.print(intervals[i][j]+" ");
            }
            System.out.println();
        }
    }
}
