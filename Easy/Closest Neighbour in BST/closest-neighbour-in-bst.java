//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int x) {
        this.key = x;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.findMaxForN(root, N));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int key;
    Node left, right;

    Node(int x)
    {
        key = x;
        left = right = null;
    }

}*/
class Solution {
    
    static int ans = -1;  
    
    public static int findMaxForN(Node root, int n) {
        
        ans = -1;       // returning max/min value close to n before searching as intial value
        inOrder(root, n);    // call inorder funstion to traverse the tree
        return ans;    
        
    }
    
    static void inOrder(Node root, int n){
        
        if(root == null) return;
        
        if(root.key <= n){                 // since root value is smaller than n , we traverse the right subtree to find greater values
            ans = Math.max(ans, root.key);
            inOrder(root.right, n);
        }
        else{
            inOrder(root.left, n);  // if root value > n, explore only left subtree
        }
        
        
    }
}