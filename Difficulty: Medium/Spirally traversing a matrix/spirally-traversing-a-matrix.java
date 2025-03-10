//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        
        int n = mat.length, m = mat[0].length, s = n*m;
        
        ArrayList<Integer> ans = new ArrayList<>();
        int a = 0, b = 0, c = n-1, d = m-1;
        
        while(ans.size() < s){
            for(int i = b; i<=d && ans.size()<s; i++) ans.add(mat[a][i]);
            a++;
            for(int i = a; i<=c && ans.size()<s; i++) ans.add(mat[i][d]);
            d--;
            for(int i = d; i>=b && ans.size()<s; i--) ans.add(mat[c][i]);
            c--;
            for(int i = c; i>=a && ans.size()<s; i--) ans.add(mat[i][b]);
            b++;
        }
        return ans;
    }
}
