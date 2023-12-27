//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            
            String input_line[] = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.antiDiagonalPattern(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
    
     int n = matrix.length;
     int[] result = new int[n*n];
     int idx = 0;
     
     //Traverse the top array
     for( int j = 0; j<n; ++j){
         int row = 0;
         int col = j;
         
         //Traverse teh anti diagonal 
     while(row<n && col>=0){
         result[idx++] = matrix[row][col];
         ++row;
         --col;
     }

    }
    
    //Traversing the rightmost column(excluding first one)
    for(int i = 1; i<n; ++i){
        int row = i; 
        int col = n-1;
        
        //Traversing the anti diagonal 
    while(row<n && col>=0){
        result[idx++] = matrix[row][col];
        ++row;
        --col;
    }
    
    }
    return result;

}
}