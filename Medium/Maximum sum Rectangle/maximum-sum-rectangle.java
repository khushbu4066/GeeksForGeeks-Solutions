//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        
        int[][] dp = new int[R][C];
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(i == 0)
                dp[i][j] = M[i][j];
                else{
                    dp[i][j] = M[i][j] + dp[i-1][j];
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int k = 0; k<R; k++){
            for(int i = k; i<R; i++){
                int sum = 0;
                for(int j = C-1; j>=0; j--){
                    int currSum = dp[i][j];
                    if(k>0)
                    currSum -= dp[k-1][j];
                    sum += currSum;
                    if(sum < currSum)
                    sum = currSum;
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
};