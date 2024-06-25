//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        int c=mat[0].length;
        int r=mat.length;
        int mod=c;
        k=(k)%c;
        for (int[] nums:mat){
        transform(nums,0,nums.length-1);
        transform(nums,0,nums.length-k-1);
        transform(nums,nums.length-k,nums.length-1);
        }
        return mat;
   
    }
    static void transform(int[] nums,int s,int e){
        while (e>s){
            swap(nums,s,e);
            s++;
            e--;
        }
    }
    static void swap(int[] nums,int f,int s){
        int temp=nums[s];
        nums[s]=nums[f];
        nums[f]=temp;
    }
}

