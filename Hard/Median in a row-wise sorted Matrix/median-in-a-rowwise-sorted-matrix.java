//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//using pointer apprach to traverse and then put the elements into the array then finding the //median simple
class Solution {
    int median(int matrix[][], int R, int C) {
        // code here        
    
      //  int arr[][]= { {1},{2},{3}};
        //boolean output = false;
        //int x = 55;
        //int r=3;
        //int c =1;
        int top =0;
        int bottom= R-1;
        int left =0;
        int right =C-1;
        int directionpointer = 0;
        int pari[] = new int[R*C];
        int p =0;
        
        while(top<=bottom && left<=right){
        if(directionpointer==0){
        for(int i=left;i<=right;i++){
              pari[p]= matrix[top][i];
            p++;
        }
        top++;
        //directionpointer++;
        } else if (directionpointer==1) {
            for(int i =top;i<=bottom;i++){
                pari[p]= matrix[i][right];
                p++;
            }
          right--;
          //directionpointer++;
        } else if(directionpointer==2){
        for(int i =right;i>=left;i-- ){
            pari[p]= matrix[bottom][i];
            p++;
        
        }
        bottom--;
        //directionpointer++;
        
        } else if(directionpointer==3){
        for(int i =bottom;i>=top;i--){
            pari[p]= matrix[i][left];
            p++;
        
        }
        left++;
        //directionpointer++;
        }
        
        directionpointer=(directionpointer+1)%4;
        
        
        }
        Arrays.sort(pari);
int n  = pari.length;
int median=0;
if(n%2 ==0){
median = (pari[n/2 - 1] +pari[n/2])/2; 

}else{
median=pari[(n+1)/2-1];


}
  return median ;
    }
}