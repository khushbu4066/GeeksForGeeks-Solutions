//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


// class Solution
// {
//     // arr[]: input array
//     // n: size of the array
//     //Function to find triplets with zero sum.
// 	public boolean findTriplets(int arr[] , int n)
//     {
//         //add code here.
//         boolean found = false;
        
//         for(int i = 0; i<n-2; i++){
//             for(int j = i+1; j<n-1; j++){
//                 for(int k = j+1; k<n; k++){
//                     if(arr[i] + arr[j] + arr[k] == 0){
                        
//                         found = true;
//                         break;
//                     }
//                 }
//                 if(found) break;
//             }
//             if(found) break;
//         }
//         return found;
        
//     }
// }

// O(n^3)




class Solution {
    // arr[]: input array
    // n: size of the array
    // Function to find triplets with zero sum.
    public boolean findTriplets(int arr[], int n) {
        // add code here.
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Create a HashSet to store elements for constant time look-up
            HashMap<Integer, Integer> hashSet = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);

                // If x is found in the hash set, we have found a triplet with zero sum
                if (hashSet.containsKey(x)) {
                    found = true;
                    break;
                } else {
                    // Add the current element to the hash set
                    hashSet.put(arr[j], j);
                }
            }

            if (found) {
                break;
            }
        }

        return found;
    }
}
