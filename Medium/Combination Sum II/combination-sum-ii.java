//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(arr);
        backtrack(arr, k, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] arr, int target, int start, List<Integer>combination, List<List<Integer>> res){
        
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        
        for(int i = start; i<arr.length; i++){
            if(i > start && arr[i] == arr[i-1])
            continue;
            
            if(arr[i] > target)
            break;
            
            combination.add(arr[i]);
            
            backtrack(arr, target-arr[i], i+1, combination, res);
            
            combination.remove(combination.size() - 1);
        }
    }
}
