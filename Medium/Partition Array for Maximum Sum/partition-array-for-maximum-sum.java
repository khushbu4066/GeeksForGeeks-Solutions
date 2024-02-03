//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int k=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.solve(N, k, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int n, int k, int arr[]){
        //Code here
        
        int[] t = new int[n+1];
        
        for(int i = 1; i<=n; i++){
            int currMax = -1;
            for(int j = 1; j <= k && i-j >= 0; j++){
                currMax = Math.max(currMax, arr[i-j]);
                
                t[i] = Math.max(t[i], t[i-j] + currMax * j);
            }
        }
        return t[n];
    }
}