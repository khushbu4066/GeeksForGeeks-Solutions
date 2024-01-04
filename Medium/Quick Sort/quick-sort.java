//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    public static void quickSort(int[] arr,int start, int end) {
		 if(end<=start){

             return ;

         }

 

          int pivot=swapping(arr,start,end);

 

         quickSort(arr, start, pivot-1);

         quickSort(arr,pivot+1,end);

 

    }

 

    private static  int swapping(int[] arr,int start,int end){

 

        int pivot=arr[end];

        int j=start-1;

        int temp=0;

 

        for (int i = start; i <=end-1; i++) {

 

            if(arr[i]<pivot){

 

                // it increase when it is in the lowest values  it stops when it value increases

                j++;

 

                   if(i!=j) {

                       temp = arr[j];

                       arr[j] = arr[i];

                       arr[i] = temp;

                   }

 

            }

 

        }

        j++;

        temp=arr[end];

        arr[end]=arr[j];

        arr[j]=temp;


       return j;
   } 
}
