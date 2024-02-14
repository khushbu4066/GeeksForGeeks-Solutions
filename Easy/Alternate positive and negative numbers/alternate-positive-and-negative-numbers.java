//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        
        ArrayList<Integer> l1 = new ArrayList<>();
         ArrayList<Integer> l2 = new ArrayList<>();
         
         for(int i = 0; i<n; i++){
             if(arr[i] < 0){
                 l2.add(arr[i]);
             }
             else{
                 l1.add(arr[i]);
             }
         }
         
         int idx = 0;
         int idx1 = 0;
         int idx2 = 0;
         for(int i = 0; i<n; i++){
             if(i<l1.size()){
                 arr[idx++] = l1.get(idx1++);
             }
             if(i < l2.size()){
                 arr[idx++] = l2.get(idx2++);
             }
         }
    }
}
