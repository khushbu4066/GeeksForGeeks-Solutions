//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution
{
  public:
   
   bool checkPangram(string str)
    {
          
        transform(str.begin(), str.end(), str.begin(), [](unsigned char c) { return tolower(c); });

        for (char i = 'a'; i <= 'z'; i++) {
            if (str.find(i) ==-1)
                return false;
        }

        return true;
    }

};

//{ Driver Code Starts.

// Driver Program to test above functions
int main()
{
    int t;
    cin>>t;
    cin.ignore(INT_MAX, '\n');
    while(t--){
        string s;
        getline(cin, s);
        Solution obj;
        if (obj.checkPangram(s) == true)
            cout<<1<<endl;
        else
            cout<<0<<endl;
    }
    return(0);
}

// } Driver Code Ends