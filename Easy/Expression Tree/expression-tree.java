//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    String data;
    Node left, right;
    Node(String d) {
        data = d;
        left = null;
        right = null;
    }
}

class ExpressionTree {
    static Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) s[i] = sc.next();
            Solution g = new Solution();

            root = null;
            makeTree(s, n);
            System.out.println(g.evalTree(root));
        }
    }

    public static boolean isExpression(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
    public static void makeTree(String[] s, int n) {
        int p = 0;
        root = new Node(s[p++]);
        Queue<Node> qq = new LinkedList<Node>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node f = qq.poll();
            Node l = null, r = null;
            if (isExpression(f.data)) {
                l = new Node(s[p++]);
                r = new Node(s[p++]);
                f.left = l;
                f.right = r;
                qq.add(l);
                qq.add(r);
            }
        }
    }
}

// } Driver Code Ends


/* A Tree node is defined as
class Node
{
    String data;
    Node left,right;

    Node(String data)
     {
     this.data = data;
     this.left = null;
     this.right = null;
     }

}*/

class Solution {
    public int evalTree(Node root) {
        // Your code here.
        
        if(root == null) return 0;
        
        if(root.left == null || root.right == null) return Integer.parseInt(root.data);
        
        int leftValue = evalTree(root.left);
        
        int rightValue = evalTree(root.right);
        //Check with operators to apply
        if(root.data.equals("+"))
            return leftValue + rightValue;
    
        
        if(root.data.equals("-"))
            return leftValue - rightValue;
        
        
        if(root.data.equals("*"))
            return leftValue * rightValue;
        
        
        return leftValue / rightValue;
    }
}