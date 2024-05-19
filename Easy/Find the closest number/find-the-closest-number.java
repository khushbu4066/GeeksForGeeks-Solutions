//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        
        if(n == 0) return -1;
        
        // Binary Search to find the position
        int l = 0, h = n - 1;
        while( l <= h){
            int mid = l + (h - l) / 2;
            
            if(arr[mid] == k){
                return arr[mid];
            }
            else if( arr[mid] < k){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        //Now low id the insertion point , comoare with neghnours
        int closest = arr[l % n];
        if(l > 0){
            int prev = arr[l - 1];
            
            // Check the closeset of the two
            if(Math.abs(prev - k) < Math.abs(closest - k) || (Math.abs(prev - k) == Math.abs(closest - k) && prev > closest)){
                closest = prev;
            }
        }
        
        return closest;
        
    }
}
        
