//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Solution {
//     static int smithNum(int n) {
//         // code here
//     }
// };
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = smithNum(n);
        System.out.println(result);
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int primeFactorsSum(int num) {
        int primeSum = 0;
        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                primeSum += sumOfDigits(i);
                num /= i;
            } else {
                i++;
            }
        }
        return primeSum;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int smithNum(int n) {
        if (isPrime(n)) {
            return 0;
        }
        int digitSum = sumOfDigits(n);
        int primeSum = primeFactorsSum(n);
        return (digitSum == primeSum) ? 1 : 0;
    }
}