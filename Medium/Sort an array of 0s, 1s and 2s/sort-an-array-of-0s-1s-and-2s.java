//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        Arrays.sort(a);
    //     int[]a1=new int[n];
    //     int c0=0,c1=0,c2=0;
    //   for(int i=0;i<n;i++)
    //   {
    //       switch(a[i]){
    //           case 0:
    //               c0++;
    //               break;
    //           case 1:
    //               c1++;
    //               break;
    //           case 2:
    //               c2++;
    //               break;
    //       }
    //   }
    //   int j=0;
      
    //   while(c0>0)
    //   {
    //       a1[j]=0;
    //       j++;
    //       c0--;
    //   }
    //   while(c1>0)
    //   {
    //       a1[j]=1;
    //       j++;
    //       c1--;
    //   }
    //   while(c2>0)
    //   {
    //       a1[j]=2;
    //       j++;
    //       c2--;
    //   }
    //   for(int i=0;i<n;i++)
    //   {
    //       a[i]=a1[i];
    //   }
    }
}




//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends