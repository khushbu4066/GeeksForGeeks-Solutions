//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// class Solution {
//     public static int sumSubarrayMins(int n, int[] arr) {
//         // code here
//         int ans = 0;
//         for(int i = 0; i<n; i++){
//             int min_ele = arr[i];
//             for(int j = i; j<n; j++){
//                 min_ele = Math.min(min_ele, arr[j]);
//                     ans += min_ele;
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    
    public int[] getNSL(int[] arr, int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }
    
    public int[] getNSR(int[] arr, int n){
        
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            result[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }
    
    public int sumSubarrayMins(int n, int[] arr) {
        
        int[] NSL = getNSL(arr,n);
        int[] NSR = getNSR(arr,n);
        
        long sum = 0;
        long M = 1000000007;
        
        for(int i = 0; i<n; i++){
        long d1 = i - NSL[i];
        long d2 = NSR[i] - i;
        
        long totalWaysOfIMin = d1*d2;
        long sumInTotalWays = arr[i] * totalWaysOfIMin;
        
        sum = (sum + sumInTotalWays) % M;
        }
        
        return (int)sum;
           
     }
}
