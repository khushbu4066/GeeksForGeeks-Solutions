//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}

class Solution {
    public static int MinimumEffort(int n, int m, int[][] heights) {
        
        PriorityQueue<Tuple> pq = 
        new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
       
      
        n = heights.length; 
        m = heights[0].length; 

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        
        dist[0][0] = 0; 
        pq.add(new Tuple(0, 0, 0)); 

         // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have 
        // in a direction.
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
        
        // Iterate through the matrix by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(pq.size() != 0) {
            Tuple it = pq.peek(); 
            pq.remove(); 
            int diff = it.distance; 
            int row = it.row; 
            int col = it.col; 
            
            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if(row == n-1 && col == m-1) return diff; 
            // row - 1, col
            // row, col + 1 
            // row - 1, col 
            // row, col - 1
            for(int i = 0;i<4;i++) {
                int newr = row + dr[i]; 
                int newc = col + dc[i];

                // Checking validity of the cell.
                if(newr>=0 && newc >=0 && newr < n && newc < m) {

                    // Effort can be calculated as the max value of differences 
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = 
                    Math.max(
                        Math.abs(heights[row][col] - heights[newr][newc]), diff); 

                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if(newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort; 
                        pq.add(new Tuple(newEffort, newr, newc)); 
                    }
                }
            }
        }
        // If the destination is unreachable.
        return 0;
    }
}