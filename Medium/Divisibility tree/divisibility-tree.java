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

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private int[] subSize;
    private int count;
    
    private void dfs(int node){
        visited[node] = true;
        subSize[node] = 1;
        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor);
                subSize[node] += subSize[neighbor];
                if(subSize[neighbor] % 2 == 0){
                    count++;
                }
            }
        }
    }
    
    public int minimumEdgeRemove(int n, int[][] edges) {
        
        adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        visited = new boolean[n+1];
        subSize = new int[n+1];
        count = 0;
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        return count;
    }
}
