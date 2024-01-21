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


// class Solution
// {
//     int t[];
//     public int solve(int[] nums, int i, int n){
        
//         if(i>= n)
//         return 0;
        
//         if(t[i] != -1)
//         return t[i];
        
//         int steal = nums[i] + solve(nums, i+2, n);
//         int skip = solve(nums,i+1,n);
        
//         return Math.max(steal, skip);
//     }
//     //Function to find the maximum money the thief can get.
//     public int FindMaxSum(int nums[], int n)
//     {
//         // Your code here
//         t = new int[101];
//         Arrays.fill(t, -1);
//         return solve(nums,0,n);
        
//     }
// }

//Bottom-UP 2nd Approach

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int nums[], int n)
    {
        // Your code here
        
        int[] t = new int[n+1];
        
        // if(n==1)
        // return nums[0];
        
        t[0] = 0;
        t[1] = nums[0];
        
        for(int i = 2; i<=n; i++){
            
            int steal = nums[i-1] + t[i-2];
            int skip = t[i-1];
            
            t[i] = Math.max(steal,skip);
            
        }
        
        return t[n];
        
    }
}