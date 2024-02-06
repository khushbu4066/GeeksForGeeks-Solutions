//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

//1st approch using temp stack
// class Solution
// { 
    
//     static void reverse(Stack<Integer> st)
//     {
//         // base 
//         if(st.isEmpty()){
//             return;
//         }
        
//         int top = st.pop();
//         reverse(st);
        
//         Stack<Integer>temp = new Stack<>();
//         while(!st.isEmpty()){
//             temp.push(st.pop());
//         }
//         st.push(top);
        
//         while(!temp.isEmpty()){
//             st.push(temp.pop());
            
//         }
//     }
// }

//2nd approach 
class Solution
{ 
    public static void insertAtBottom(Stack<Integer>st ,int element){
        
        if(st.isEmpty()){
            st.push(element);
            return; // base cond
        }
        
        int curTopEle = st.pop();
        insertAtBottom(st, element);
        st.push(curTopEle);
    }
    
    
    static void reverse(Stack<Integer> st)
    {
        // base 
        if(st.isEmpty()){
            return;
        }
        
        int top = st.pop();
        reverse(st);
        insertAtBottom(st, top);
        
    }
}