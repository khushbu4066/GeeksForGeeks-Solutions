//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    
   static int[][] dp;
    public int editDistance(String s, String t) {
        
        int n=s.length();
        int m=t.length();
        
        dp=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        int res=solve(s,t,n-1,m-1,dp);
        
        return res;
    }
    
    static int solve(String s, String t,int n , int m , int[][] dp)
    {
        int ans;
        
        if(n<0)
        return m+1;
        
        if(m<0)
        return n+1;
        
        if(dp[n][m]!=-1)
        return dp[n][m];
        
        if(s.charAt(n)==t.charAt(m))
        {
            ans=solve(s,t,n-1,m-1,dp);
            dp[n][m]=ans;
        }
        else
        {
            ans=1+Math.min(solve(s,t,n,m-1,dp),Math.min(solve(s,t,n-1,m,dp),solve(s,t,n-1,m-1,dp)));
            dp[n][m]=ans;
        }
        
        return ans;
    }
}