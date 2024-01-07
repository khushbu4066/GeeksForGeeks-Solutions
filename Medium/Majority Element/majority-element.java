//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int arr[], int n)
    {
        // your code here
        HashMap<Integer, Integer> ans = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            ans.put(arr[i],ans.getOrDefault(arr[i],0)+1);
        }
        
        int c = -1;
        for(int j = 0; j<n; j++){
            if(ans.get(arr[j]) > n/2){
                c = arr[j];
            }
        }
        return c;
        
    }
}