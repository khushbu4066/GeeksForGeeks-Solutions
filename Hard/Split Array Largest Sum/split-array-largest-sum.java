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
    static boolean isFeasible(int[] arr , int N, int K, int mid) {
        // code here
        int count = 1;
        int sum = 0;
        
        for(int i = 0; i<N; i++){
            if(arr[i] > mid){
                return false;
            }
            if(sum + arr[i] >mid){
                count++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }
        return count <= K;
    }
    
    static int splitArray(int[] arr , int N, int K) {
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i<N; i++){
            end += arr[i]; // Sum of the whole array is the upper bound
        }
        int result = Integer.MAX_VALUE;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(isFeasible(arr,N,K,mid)){
                
                result = Math.min(result, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return result;
    }
};