//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Solution
// {
//     // arr[]: Input Array
//     // N : Size of the Array arr[]
//     //Function to count inversions in the array.
//     static long inversionCount(long arr[], long n)
//     {
//         // Your Code Here
        
// //1st Approach     // long count = 0;
//         // for(int i = 0; i<n-1; i++){
//         //     for(int j = i+1; j<n; j++){
//         //         if(arr[i] > arr[j]){
//         //             count++;
//         //         }
//         //     }
//         // }
//         // return count;
        
//         //TLE
        
//         //2
        
        
        
//     }
// }

// Using Merge Sort

class Solution
{
    static long inversionCount(long arr[], long n)
    {
        long low = 0;
        long high = n-1;
        return inv (arr,low,high);
    }
    
    public static long inv(long arr[], long low, long high){
        long res = 0;
        if(high > low ){
            long mid = (low + high)/2;
            res +=inv(arr, low, mid);
            res +=inv(arr,mid+1,high);
            res +=countMerge(arr,mid,low,high);
        }
        return res;
    }
    
    static long countMerge(long arr[], long mid, long low, long high){
        long n1 = mid - low + 1;
        long n2 = high - mid;
        long res = 0;
        long left[] = new long[(int)n1];
        long right[] = new long[(int)n2];
        for(int i=0;i<n1;i++){
            left[i] = arr[i+(int)low];
        }
        for(int j=0;j<n2;j++){
            right[j] = arr[(int)mid+1+j];
        }
        int i=0;
        int j=0;
        int k = (int)low;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
                res = res+(n1 - i);
                
            }
        }
         while(i<n1 ){
            
                arr[k++] = left[i++];
           
        }
        while(j<n2 ){
            
                arr[k++] = right[j++];
           
        }
        return res;
    }
    
}

























