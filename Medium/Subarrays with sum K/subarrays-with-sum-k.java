//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Solution
// {
//     static int findSubArraySum(int arr[], int n, int s)
//     {
//         // code here
        
//         ArrayList<Integer> res = new ArrayList<>();
//         int count = 0;
        
//         for(int i = 0; i<n; i++){
//             int sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += arr[j];
//                 if(sum == s){
//                     count++;
//                 }
                
//             }
//         }
        
//         return count;
        
//     }
// }

class Solution
{
    static int findSubArraySum(int arr[], int n, int s)
    {
     int ans = 0, sum = 0;
     
     HashMap<Integer, Integer> mp = new HashMap<>();
     mp.put(sum, 1);
     
     for(int i = 0; i<n; i++){
         sum += arr[i];
         
         if(mp.containsKey(sum - s)){
             ans += mp.get(sum - s);
         }
         
         mp.put(sum, mp.getOrDefault(sum, 0)+ 1);
     }
     
     return ans;
        
    }
}