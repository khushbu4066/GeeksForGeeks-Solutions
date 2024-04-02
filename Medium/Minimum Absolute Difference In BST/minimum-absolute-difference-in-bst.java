//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
 class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class GFG {

static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
  public static void main(String[] args) throws IOException {
    BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(bu.readLine());
    while (T-- > 0) {
      
      String s=bu.readLine();
      Node root = buildTree(s);
       if (root == null)
        continue;
      if (root.left == null && root.right == null)
        continue;
      Solution obj = new Solution();
      int ans = obj.absolute_diff(root);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/
// class Solution
// {
//     private static void preOrder(Node root, List<Integer>ls){
//         if(root == null) return;
        
//         ls.add(root.data);
//         preOrder(root.left, ls);
//         preOrder(root.right, ls);
//     }
    
//     int absolute_diff(Node root)
//     {
//         //Your code here
        
//         List<Integer>ls = new ArrayList<>();
        
//         preOrder(root, ls);
        
//         int min_diff = Integer.MAX_VALUE;
//         int n = ls.size();
        
//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//               int x = Math.abs(ls.get(i) - ls.get(j));
//               if(min_diff > x){
//                   min_diff = x;
//               }
//             }
//         }
        
//         return min_diff;
//     }
    
// }

// Time complexity = O(n^2)
// space complexity = o(n)

// using INorder
class Solution
{
    
    static Node prev;
    static int ans;
    
    private static void inOrder(Node curr){
        
        if(curr == null) return;
        
        inOrder(curr.left);
        
        if(prev != null){
            ans = Math.min(curr.data - prev.data, ans);
        }
        
        prev = curr;
        
        inOrder(curr.right);
    }
    
    int absolute_diff(Node root)
    {
        
        prev = null;
        
        ans = Integer.MAX_VALUE;
        
        inOrder(root);
        
        return ans;
    }
    
}
