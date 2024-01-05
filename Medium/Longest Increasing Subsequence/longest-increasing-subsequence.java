//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
         LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int i = 0; i  <size; i++){
            
            int index = 0;
            boolean updated = false;
            
            while(!list.isEmpty() && index < list.size()){
                if(a[i] <= list.get(index) ){
                 list.remove(index);
                 list.add(index, a[i]);
                 updated = true;
                  break;
                    
                }
                
               index++;
            }
            
             if(updated != true)
                 list.add(a[i]);
        }
        
        return list.size();
        
        
        // int[] t = new int[n];
        // Arrays.fill(t,1);
        // int maxLIS = 1;
        
        // for(int i = 1; i<n; i++){
        //     for(int j = 0; j<i; j++){
        //         if(arr[i] > arr[j]){
        //             t[i] = Math.max(t[i], t[j]+1);
        //             maxLIS = Math.max(maxLIS, t[i]);
        //         }
        //     }
        // }
        // return maxLIS;
    }
} 