//{ Driver Code Starts
// Initial Template for Java
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    private int timer = 0;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];

        for (int i = 0; i < V; i++) {
            dfs(0, -1, tin, low, vis, mark, adj);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }

    void dfs(int node, int par, int[] tin, int[] low, boolean[] vis, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        int child = 0;

        for (int it : adj.get(node)) {
            if (it == par) continue;

            if (!vis[it]) {
                dfs(it, node, tin, low, vis, mark, adj);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && par != -1) {
                    mark[node] = 1;
                }

                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (child > 1 && par == -1) {
            mark[node] = 1;
        }
    }
}