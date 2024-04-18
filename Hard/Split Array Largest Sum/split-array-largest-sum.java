//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static boolean isPossible(int[] arr, int mid, int k) {
        int sub_array = 1, sum = 0;
        
        for (int num: arr) {
            sum += num;
            if (sum > mid) {
                sub_array++;
                sum = num;
            }
        }
        
        return sub_array <= k;
    }
    
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int max = 0, sum = 0;
        
        for (int val: arr) {
            sum += val;
            max = Math.max(max, val);
        }
        
        if (K == N) return max;
        
        int start = max, end = sum, ans = 0;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (isPossible(arr, mid, K)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
}; // best solutio