//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends


class solve{
private static int fun(int s,int e,int arr[],int dp[][]){
        if(s > e)return 0;
        if(s == e)return arr[s];
        if(dp[s][e] != -1){
            return dp[s][e];
        }

//ask the opponents minimum optimal ans i.e. take min of what opponent can do 


        int first = arr[s];
        //pick first
        first += Math.min(fun(s+2,e,arr,dp),fun(s+1,e-1,arr,dp));
        
        int last = arr[e];
        //pick last
        last += Math.min(fun(s+1,e-1,arr,dp),fun(s,e-2,arr,dp));

        return dp[s][e] = Math.max(first,last);
    }
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return fun(0,n-1,arr,dp);
    }

}
