//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Jav

class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // int currentSum = 0;

        // // Sum the first 'k' elements
        // for (int i = 0; i < k; i++) {
        //     currentSum += Arr.get(i);
        // }
        // long maxSum = currentSum;

        // // Iterate through the rest of the array using the sliding window technique
        // for (int i = k; i < n; ++i) {
        //     // Update currentSum by adding the new element at the end of the window
        //     // and subtracting the element that is no longer part of the window
        //     currentSum = currentSum + Arr.get(i) - Arr.get(i - k);

        //     // Update maxSum to be the maximum of the current sum and the previous maximum sum
        //     maxSum = Math.max(maxSum, currentSum);
        // }
        // return maxSum;   
        
        //Not passing for 3 test cases🥲 Just updated little bit
        
        long sum = 0, ans = 0;
        
        for(int i=0;i<K;i++) {
            sum += Arr.get(i);
        }
        
        ans = Math.max(ans, sum);
        
        int i=0;
        for(int j=K;j<N;j++) {
            sum -= Arr.get(i++);
            sum += Arr.get(j);
            
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
    
    
    