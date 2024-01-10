//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        int dp[][]=new int[2][r+1];
        dp[0][0]=1;
        dp[1][0]=1;
        for(int i=1;i<=r;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                dp[i%2][j]=((dp[(i-1)%2][j])%1000000007+(dp[(i-1)%2][j-1])%1000000007)%1000000007;
            }
        }
        return dp[n%2][r];
    }
}