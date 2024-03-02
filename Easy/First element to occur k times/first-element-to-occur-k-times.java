//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(n, k, arr));
		}
	}
}

// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int n, int k, int[] arr) { 
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
                
                if(map.get(arr[i]) >= k){
                    return arr[i];
                }
            } else {
                map.put(arr[i], 1);
            }
        }
        
        // for(int key : map.keySet()){
        //     if(map.get(key) >= k){
        //         return key;
        //     }
        // }
        
        return -1; 
        
    } 
}