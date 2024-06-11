//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        
        class Order {
        int tipA;
        int tipB;
        int diff;

        public Order(int tipA, int tipB) {
            this.tipA = tipA;
            this.tipB = tipB;
            this.diff = Math.abs(tipA - tipB);
        }
    }

    Order[] orders = new Order[n];

    // Create orders with the respective tips
    for (int i = 0; i < n; i++) {
        orders[i] = new Order(arr[i], brr[i]);
    }

    // Sort orders based on the absolute difference of tips in descending order
    Arrays.sort(orders, new Comparator<Order>() {
        public int compare(Order o1, Order o2) {
            return o2.diff - o1.diff;
        }
    });

    long totalTip = 0;
    int countA = 0, countB = 0;

    // Assign orders to maximize tips
    for (Order order : orders) {
        if ((order.tipA >= order.tipB && countA < x) || countB == y) {
            totalTip += order.tipA;
            countA++;
        } else {
            totalTip += order.tipB;
            countB++;
        }
    }

    return totalTip;


    }
}
