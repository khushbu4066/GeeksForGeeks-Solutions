//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static boolean isPossible(int N, int[] coins) {
        // code here
        if(N==1){
            if(coins[0]==2024 || coins[0]%20==0 || coins[0]%24==0)return true;
            return false;
        }
        boolean[][] dp = new boolean[N+1][2025];
        for(int i=0;i<=N;i++){
            dp[i][0]=true;
        }
        for(int j=1;j<=N;j++){
            for(int i=1;i<2025;i++){
              if(coins[j-1]>i){
                  dp[j][i]=dp[j-1][i];
              }else if(dp[j-1][i] || dp[j-1][i-coins[j-1]]){
                  dp[j][i]=true;
              }
              if(dp[j][i] && (i%20==0 || i%24==0))return true;
            }
        }
        return dp[N][2024];
        
    }
}
        
