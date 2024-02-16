//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    //Global variable declaration
    private static int[] di = {+1, 0, 0, -1};
    private static int[] dj = {0, -1, +1, 0};
    
    public static void solve(int[][] m, int n, int[][] vis, int i, int j, ArrayList<String> ars, String ref){
        if(i == n-1 && j == n-1){
            ars.add(ref);
            return;
        }
        
        String st = "DLRU";
        
        for(int l = 0; l<4; l++){
            int dc = i + di[l];
            int dd = j + dj[l];
            
            if(dc >= 0 && dd>=0 && dc < n && dd<n && vis[dc][dd]==0 && m[dc][dd]==1){
                vis[i][j] = 1;
                solve(m, n, vis, dc, dd, ars, ref + st.charAt(l));
                //backtracking
                vis[i][j] = 0;
            }
        }
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ars = new ArrayList<>();
        
        int[][] visited = new int[n][n];
        String ref = "";
        
        if(m[0][0] == 1){
            solve(m, n, visited, 0, 0, ars, ref);
        }
        
        if(ars.isEmpty()){
            ars.add("-1");
        }
        
        return ars;
        
    }
}