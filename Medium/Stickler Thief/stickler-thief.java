//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        if(n==1) return arr[0];
        
        int[] t = new int[n+1];
        Arrays.fill(t, 0);
        
        t[0] = 0;
        t[1] = arr[0];
        
        for(int i = 2; i<=n; i++){
            
            int steal = arr[i-1] + t[i-2];
            int skip =  t[i-1];
            
            t[i] = Math.max(steal, skip);
        }
        return t[n];
    }
}