#User function Template for python3

class Solution:
    def kthElement(self, k, arr1, arr2):
        def kth_smallest(a, b, k):
            if len(a) > len(b):
                a, b = b, a
            if not a:
                return b[k-1]
            if k == 1:
                return min(a[0], b[0])
            i = min(len(a), k // 2)
            j = min(len(b), k // 2)
            if a[i - 1] > b[j - 1]:
                return kth_smallest(a, b[j:], k - j)
            else:
                return kth_smallest(a[i:], b, k - i)
        return kth_smallest(arr1, arr2, k)    
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():

    T = int(input())

    while (T > 0):

        k = int(input())
        a = [int(x) for x in input().strip().split()]
        b = [int(x) for x in input().strip().split()]
        ob = Solution()
        print(ob.kthElement(k, a, b))

        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends