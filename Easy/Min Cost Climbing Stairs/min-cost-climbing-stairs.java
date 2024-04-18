//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int find(int arr[],int n , int dp[]){
        if(n == 0)return arr[n];
        if(n < 0)return 0;
        if(dp[n] != -1)return dp[n];
        dp[n] = Math.min(find(arr,n-1,dp),find(arr,n-2,dp))+arr[n];
        return dp[n];
    }
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        int dp[] = new int[N+1];
        for(int i = 0 ; i <= N ; i++)dp[i] =-1;
        int ans = Math.min(find(cost,N-1,dp),find(cost,N-2,dp));
        return ans;
    }
};