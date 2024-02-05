//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void s(Stack<Integer>s, Stack<Integer>temp, int n, int m){
        
        if(n==m){
            s.pop();
            return;
        }
        
        //for pushing s to temp
        temp.push(s.pop());
        s(s,temp, n-1, m);
        
        s.push(temp.pop());  // for pusing temp to s
    }
    
    
    
    public void deleteMid(Stack<Integer>s,int n){
        // code here
        
        Stack<Integer>temp = new Stack<>();
        int m = (n+1)/2;
        s(s,temp,n,m);
        
    } 
}

