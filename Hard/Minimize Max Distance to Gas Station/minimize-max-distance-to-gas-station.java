//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static double findSmallestMaxDist(int[] stations, int k) {
        int n = stations.length;
        double left = 0, right = getMaxDistance(stations);

        // Binary search for the smallest possible maximum distance
        while (right - left > 1e-6) { // Precision of 1e-6 for the required two decimal places
            double mid = (left + right) / 2;
            if (canPlaceStations(stations, n, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.round(right * 100.0) / 100.0; // Return result rounded to 2 decimal places
    }
    
     static boolean canPlaceStations(int[] stations, int n, int k, double mid) {
        int requiredStations = 0;

        for (int i = 1; i < n; i++) {
            double distance = stations[i] - stations[i - 1];
            requiredStations += Math.ceil(distance / mid) - 1; // Calculate the number of stations needed
        }

        return requiredStations <= k;
    }

    static double getMaxDistance(int[] stations) {
        double maxDistance = 0.0;

        for (int i = 1; i < stations.length; i++) {
            maxDistance = Math.max(maxDistance, stations[i] - stations[i - 1]);
        }

        return maxDistance;
    }
}