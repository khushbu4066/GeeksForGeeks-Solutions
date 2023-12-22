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
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] s, int[] f) {
        
        ArrayList<Integer> ans =new ArrayList<>();
        ArrayList <ArrayList<Integer>> arr=new ArrayList<>();
        
        for(int i=0;i<n;i++) {
        	ArrayList<Integer> temp=new ArrayList<>();
        	temp.add(s[i]);
        	temp.add(f[i]);
        	temp.add(i+1);
        	arr.add(temp);        	
        }
        
        Collections.sort(arr,(a,b)->(a.get(1)-b.get(1)));
        
        ans.add(arr.get(0).get(2));
        int end=arr.get(0).get(1);
        for(int i=1;i<n;i++) {
        	if(end<arr.get(i).get(0)) {
        		ans.add(arr.get(i).get(2));
        		end=arr.get(i).get(1);
        	}
        }
        Collections.sort(ans);
        return ans;
    }
}