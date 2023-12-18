//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.gameOfXor(N,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int gameOfXor(int N , int[] A) {
        int ele = 0;
        if((N & 1) == 0){
            return 0;
        }
        for(int i =0; i<N; i= i+2){
            
            ele = ele ^ A[i];
            
        }
        return ele;
    //     int i =0;
    //     ArrayList<Integer> lst = new ArrayList<>();
    //     combination(N, A, i, lst);
    //     return 0;
        
        
        
    //     // code here
    // }
    
    // static void combination(int N, int []arr, int i, ArrayList<Integer> lst){
        
    //     if(lst.size() == arr.length){
    //         System.out.println(lst);
    //         //for(int j =0; j<lst.size(); j++)
    //         return;
            
    //     }
        
    //     combination(N, arr, i, lst);
    //     combination(N, arr, i+1, lst.add(arr[i]));
        
    }
};