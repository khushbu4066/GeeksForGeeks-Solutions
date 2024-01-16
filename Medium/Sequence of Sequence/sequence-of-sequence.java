//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int m, int n, int dp[][])
    {
        // code here
         if(n==0)return 1;
        if(m==0)return 0;
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        dp[m][n] =  solve(m/2,n-1,dp)+solve(m-1,n,dp);
        return dp[m][n];
    }
   static int numberSequence(int m, int n){
        // code here
        int dp [][] = new int[m+1][n+1];
        for(int a [] : dp){
            Arrays.fill(a,-1);
        }
        return solve(m,n,dp);
    }
}