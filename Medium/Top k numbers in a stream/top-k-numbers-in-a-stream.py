#User function Template for python3

class Solution:
    def kTop(self, array, size, k):
        result = []
        current_top = [0 for _ in range(k + 1)]  # Array to store the current top K elements
        frequency = {i: 0 for i in range(k + 1)}  # Dictionary to store the frequency of elements in current_top

        for index in range(size):
            # Update the frequency of the current element in the array
            frequency[array[index]] = frequency.get(array[index], 0) + 1

            # Set the last element of current_top as the current element from the array
            current_top[k] = array[index]

            # Find the correct position for the current element in the current_top array
            i = current_top.index(array[index]) - 1
            while i >= 0:
                # Compare frequencies and values for sorting
                if (frequency[current_top[i]] < frequency[current_top[i + 1]]) or \
                        ((frequency[current_top[i]] == frequency[current_top[i + 1]]) and
                         (current_top[i] > current_top[i + 1])):
                    current_top[i], current_top[i + 1] = current_top[i + 1], current_top[i]
                else:
                    break
                i -= 1

            # Extract the top K elements and append them to the result list
            i = 0
            current_result = []
            while i < k and current_top[i] != 0:
                current_result.append(current_top[i])
                i += 1

            result.append(current_result)

        return result
#{ 
 # Driver Code Starts


t=int(input())
for _ in range(0,t):
    n,k=list(map(int,input().split()))
    a=list(map(int,input().split()))
    ob = Solution()
    ans=ob.kTop(a,n,k)
    for line in ans:
        print(*line)



# } Driver Code Ends