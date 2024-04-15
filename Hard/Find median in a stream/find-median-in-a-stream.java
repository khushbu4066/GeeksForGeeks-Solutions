//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution{
    
    static PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> right=new PriorityQueue<>();
    
    public static void insertHeap(int x){
        if(left.size()==0){
            left.add(x);
        }
        else if(left.size()>right.size()){
            right.add(x);
            balanceHeaps();
        }
        else{
            left.add(x);
            balanceHeaps();
        }
    }
    public static void balanceHeaps(){
        if(left.peek()>right.peek()){
            int temp1=left.poll();
            int temp2=right.poll();
            left.add(temp2);
            right.add(temp1);
        }
    }
    
    //Function to return Median.
    public static double getMedian(){
        if(left.size()>right.size()){
            return (double)left.peek();
        }
        else{
            int x=left.peek();
            int y=right.peek();
            double res=(x+y)/2;
            return res;
        }
    }
    
}
 