//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// //User function Template for Java

// class Solution
// {
//     private int[] t;
    
//   public int solve(String s, int i, int n){
        
//          if (t[i] != -1) {
//             return t[i];
//         }

//         if (i == n) {
//             return t[i] = 1; // one valid split done
//         }

//         if (s.charAt(i) == '0') {
//             return t[i] = 0; // not possible to split
//         }

//         int result = solve(i + 1, s, n);

//         if (i + 1 < n) {
//             if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
//                 result += solve(i + 2, s, n);
//         }

//         return t[i] = result % 1000000007;
        
//     }
    
//     public int CountWays(String s)
//     {
//         int n = s.length();
//         t = new int[n+1];
//         Arrays.fill(t, -1);
//         return solve(0, s, n);
//     }
// }

class Solution{

public static final int mod = 1000000007;
    public int CountWays(String str)
    {
        // code here
        return f(str,0,-1,new Integer[str.length()][28]);
    }
    
    public static int f(String s,int idx,int code,Integer[][] dp) {
        if(code==0 || code>26) return 0;
        if(idx>=s.length()) {
            return 1;
        }
        if(dp[idx][code+1]!=null) return dp[idx][code+1];
        int ans=0;
        ans = add(ans,f(s,idx+1,s.charAt(idx)-'0',dp));
        if(idx!=0) ans = add(ans,f(s,idx+1,(10*code)+(s.charAt(idx)-'0'),dp));
        
        return dp[idx][code+1]=ans;
    }
    
    public static int add(int a,int b) {
        return ((a%mod)+(b%mod))%mod;
    }
}