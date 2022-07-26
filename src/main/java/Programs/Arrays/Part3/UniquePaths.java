package Programs.Arrays.Part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniquePaths {

    //exponential T.C. and S.C. since we're calculating every possible outcome. i.e. 2^n
    private static int uniquePathsRecursive(int m, int n, int i, int j){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        return uniquePathsRecursive(m, n, i+1, j)+uniquePathsRecursive(m, n, i, j+1);
    }

    private static int uniquePaths(int m, int n){
//        return uniquePathsRecursive(m ,n, 0, 0);

        //Approach2
//        int[][] dp=new int[m][n];
//        //filling dp initially with -1
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++) dp[i][j]=-1;
//        }
//        return uniquePathsDp(m, n, 0, 0, dp);


        //Approach3
        //T.C. : O(m-1) or O(n-1)
        //S.C. : O(1)
        int N=(m+n-2);
        int R=m-1;
        double result=1;
        for(int i=1; i<=R; i++){//for denominator, no. from 1 to R
            result = result * (N-R+i)/i;
        }
        return (int)result;
    }

    //T.C. : O(m*n)
    //S.C. : O(m*n)
    private static int uniquePathsDp(int m, int n, int i, int j, int[][] dp){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;

        //functionality of dp, check if current solution of recursive call is present in dp, then simply return it. No need to call it again in recursion.
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]=uniquePathsDp(m, n, i+1, j, dp)+uniquePathsDp(m, n, i, j+1, dp);
    }



    public static void main(String[] args) {
        int m=3, n=2;
        int result=uniquePaths(m, n);
        System.out.println(result);
    }
}
