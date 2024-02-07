//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
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
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}


// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    private static Map<Integer, Integer> dist;
    private static int ans;
    int findDist(Node root, int a, int b) {
        // Your code here
        if(a == b)  return 0;
        dist = new HashMap<>();
        dist.put(a, -1); dist.put(b, -1);
        ans = -1;
        dfs(root, a, b);
        return ans;
    }
    private static Set<Integer> dfs(Node root, int a, int b) {
        if(root == null || ans != -1)    return new HashSet<>();
        Set<Integer> leftSide = dfs(root.left, a, b);
        Set<Integer> rightSide = dfs(root.right, a, b);
        Set<Integer> ret = new HashSet<>();
        ret.addAll(rightSide);
        ret.addAll(leftSide);
        
        if(root.data == a) {
            dist.put(a, 0);
            ret.add(a);
            if(ans == -1 && (ret.contains(b)))
                ans = dist.get(b);
        } else if (root.data == b) {
            dist.put(b, 0);
            ret.add(b);
            if(ans == -1 && (ret.contains(a)))
                ans = dist.get(a);
        } 
        if(ans == -1 && (leftSide.contains(a) && rightSide.contains(b)) || (leftSide.contains(b) && rightSide.contains(a))) {
            ans = dist.get(a) + dist.get(b);
        }
        if(ans == -1) {
            if(dist.get(a) > -1 && (root.data == a || ret.contains(a)))    dist.put(a, dist.get(a) + 1);
            if(dist.get(b) > -1 && (root.data == b || ret.contains(b)))    dist.put(b, dist.get(b) + 1);
        }
        
        return ret;
    }
}

