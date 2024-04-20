//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

// class Solution {

//     ArrayList<Integer> findSubarray(int a[], int n) {
        
//         ArrayList<Integer> ans = new ArrayList<>();
        
//         int maxi = Integer.MIN_VALUE;
//         int sum = 0;
        
//         int start = 0;
//         int ansStart = -1, ansEnd = -1;
        
//         for(int i = 0; i<n; i++){
//             if(sum == 0) start = i;
//             sum += a[i];
            
//             if(sum > maxi){
//                 maxi = sum;
                
//                 ansStart = start;
//                 ansEnd = i;
//             }
//             if(sum < 0){
//                 sum = 0;
//             }
            
//             ans.add(a[i]);
//         }
        
//         return ans;
//     }
// }


 class Solution {
    
        ArrayList<Integer> findSubarray(int a[], int n) {
            // code here
            boolean flag=false;
            // this loop is just for check the prsence of positive element or not 
            for(int i=0;i<n;i++){
                if(a[i]>=0){
                    flag=true;
                }
            }
            // corner case ....
            if(flag==false){
                return new ArrayList<>(-1);
            }
            
            //////------------------ Main code 
            // two array List intialization 
            // one for final ans
            //second for track of ans
            //
            
            ArrayList<Integer> ans=new ArrayList<>();
            ArrayList<Integer> temp=new ArrayList<>();
            // 
            //   similarly two varible sum and res 
            //    sum =local sum and res global sum
            //
            int sum=0;
            int res=0;
            for(int i=0;i<n;i++){
                // if element is not -ve just do sum and add element to the temp 
                if(a[i]>=0){
                    temp.add(a[i]);
                    sum+=a[i];
                }else {// if -ve encounter 
                    // work to be done
                  
                  
                  // if local sum is greater than global sum update it 
                    if(sum>res){
                        res=sum;
                      // System.out.println("hii1");
                        ans=new ArrayList<>(temp);
                        
                    }
                    // if sum eqaul comapare the size of two array global and local 
                    else if(sum==res){
                        if(temp.size()>ans.size()){
                            ans=new ArrayList<>(temp);
                        }
                       // temp=new ArrayList<>();
                    }
                    temp=new ArrayList<>();
                    sum=0;
                }
            }
            // last do check if subarray ending at the last element of array 
            if(sum>res){
                        res=sum;
                     //   System.out.println("hii1");
                        ans=new ArrayList<>(temp);
                        temp=new ArrayList<>();
                    }
                     else if(sum==res){
                        if(temp.size()>ans.size()){
                            ans=new ArrayList<>(temp);
                        }
                    }
                    
            return ans;
        }
    }

