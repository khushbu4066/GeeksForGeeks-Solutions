//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

#include <bits/stdc++.h>
using namespace std;
 
 
// } Driver Code Ends
class Solution
{
    public:
    //Function to find largest rectangular area possible in a given histogram.
    long long getMaxArea(long long arr[], int n)
    {
          vector<long long> ans(n, -1);
        stack<pair<long long, long long>> st, st1;
        vector<long long> ans1(n, n);
        for (int i = 0; i < n; i++)
        {
            while (!st.empty() and st.top().first >=arr[i])
            {
                st.pop();
            }
            if (!st.empty())
            {
                ans[i] = st.top().second;
            }
            st.push({arr[i], i});
        }
        for (int i = n - 1; i >= 0; i--)
        {
            while (!st1.empty() and st1.top().first >= arr[i])
            {
                st1.pop();
            }
            if (!st1.empty())
            {
                ans1[i] = st1.top().second;
            }
            st1.push({arr[i], i});
        }
       // reverse(ans1.begin(),ans1.end());
        long long mx = 0;
        for (int i = 0; i < n; i++)
        {
           long long mn= arr[i] * (ans1[i] - ans[i] - 1);
           mx=max(mn,mx);
        }
        return mx;
    }
};


//{ Driver Code Starts.

int main()
 {
    long long t;

    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        
        long long arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        Solution ob;
        cout<<ob.getMaxArea(arr, n)<<endl;
    
    }
	return 0;
}

// } Driver Code Ends