package com.test.newalgo.dp;

public class UniquePathsDP {
    public static void main(String args[]){
        int m=3;
        int n=7;
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = -1;
            }
        }
        int paths = countPaths(0,0,m,n,arr);
        System.out.println(paths);

    }

    private static int countPaths(int i, int j, int m, int n, int[][] arr){
        if((i==(m-1)) && (j==(n-1)))
        {
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(arr[i][j] != -1){
            return arr[i][j];
        }
        int rowCnt = countPaths(i+1, j, m, n, arr);
        int colCnt = countPaths(i,j+1,m,n,arr);
        return arr[i][j] = rowCnt + colCnt;
    }
}
