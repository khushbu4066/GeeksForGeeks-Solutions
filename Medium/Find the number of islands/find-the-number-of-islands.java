//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution{
    
    
    public void dfs(char[][] grid, int i, int j, boolean visited[][]){
        
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        
        visited[i][j] = true;
        dfs(grid, i+1, j, visited);  //down
        dfs(grid, i-1, j, visited); // up
        dfs(grid, i, j+1, visited);  //right
        dfs(grid, i, j-1, visited);   // left
        dfs(grid, i+1, j+1, visited);   //down right
        dfs(grid, i-1, j-1, visited);   // up left
        dfs(grid, i+1, j-1, visited);   // down left
        dfs(grid, i-1, j+1, visited);   // up right
    }
    
    
    public int numIslands(char[][] grid){
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        int c = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] != '0' && visited[i][j] == false){
                    dfs(grid, i, j, visited);
                    c++;
                }
            }
        }
        
        return c;
    }
}