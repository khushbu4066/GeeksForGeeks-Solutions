//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
// class Solution {

//     // arr: input array
//     // Function to find the sum of contiguous subarray with maximum sum.
//     int maxSubarraySum(int[] arr) {
        
//         int maxi = Integer.MIN_VALUE;
//         int n = arr.length;

//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 int sum = 0;
                
//                 for(int k = i; k<=j; k++){
//                     sum += arr[k];
//                 }
                
//                 maxi = Math.max(maxi, sum);
//             }
//         }
//         return maxi;
//     }
// }

//First taking all the subarraySum and after that using one more looop checking whether the given sum is max from the previous sum or not

// 
// class Solution {

//     // arr: input array
//     // Function to find the sum of contiguous subarray with maximum sum.
//     int maxSubarraySum(int[] arr) {
        
//         int maxi = Integer.MIN_VALUE;
//         int n = arr.length;
        
//         for(int i = 0; i<n; i++){
//             int sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += arr[j];
                
//                 maxi = Math.max(maxi, sum);
//             }
//         }
//         return maxi;
//     }
// }

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            
            if(sum > maxi){
                maxi = sum;
            }
            
            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;
        
    }
}

