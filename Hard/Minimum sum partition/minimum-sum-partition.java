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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
 
public int minDifference(int arr[], int n) 
{ 
    // Your code goes here
    int tsum=0;
    for (int i=0;i<n;i++)tsum+=arr[i];
    int mid=tsum/2;
    int ans=0;
    int dp[][]=new int[n+1][mid+1];
    for(int i=0;i<=n;i++){
        for(int j=0;j<=mid;j++)dp[i][j]=0;
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=mid;j++){
            if(arr[i-1]>j){
                dp[i][j]=dp[i-1][j];    
            }else
            {
                dp[i][j]=Math.max(dp[i-1][j],arr[i-1]+dp[i-1][j-arr[i-1]]);
            }
            
        }
    }
    int s1=dp[n][mid];
    ans=Math.abs(tsum-2*s1);
    return ans;
} 
}