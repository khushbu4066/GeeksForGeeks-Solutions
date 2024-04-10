//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

// class Solution
// {
//     long dp[];
    
//     long solve(int n, long[] dp){
        
//         if(n <= 2) return n;
        
//         if(dp[n] != -1) return dp[n];
       
//         return dp[n] = solve(n-1, dp) + (n-1) * solve(n-2, dp);
        
//     }
    
//     public long countFriendsPairings(int n) 
//     { 
//       dp = new long[n+1];
//       Arrays.fill(dp, -1);
//       dp[0] = dp[1] = 1;
//       return solve(n, dp);
//     }
// }    


// class Solution
// {
//     public long countFriendsPairings(int n) 
//     { 
//       long[] dp = new long[n+1];
       
//       dp[0] = 1;
//       dp[1] = 1;
       
//       for(int i = 2; i<=n; i++){
           
//           dp[i] = 1 * dp[i-1] + (i-1) * dp[i-2];
//       }
       
//       return dp[n];
//     }
// }    
 
// class Solution
// {
//     public long countFriendsPairings(int n) 
//     { 
//       //code here
//       long dp[] = new long[n+1];
//       Arrays.fill(dp,-1);
//       return solve(n,dp);
//     }
//     public static long solve(int n,long dp[]){
//       if(n == 0){
//           return 1;
//       }
//       if(dp[n] != -1){
//           return dp[n];
//       }
//       long single = solve(n-1,dp);
//       long pair = 0;
//       if(n - 2 >= 0){
//           pair = solve(n-2,dp) * (n - 1);
//       }
//       return dp[n] = (single + pair) % 1000000007;
//     }
    
// }    


class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       long dp[] = new long[n+1];
       Arrays.fill(dp,-1);
       dp[0] = 1;
       for(int i=1;i<=n;i++){
       long single = dp[i-1];
       long pair = 0;
       if(i - 2 >= 0){
           pair = dp[i-2] * (i - 1);
       }
         dp[i] = (single + pair) % 1000000007;
       }
       return dp[n];
    }
    
}    