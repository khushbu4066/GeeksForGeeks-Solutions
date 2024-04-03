//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// A Tree node
struct Node
{
	int data;
	struct Node *left, *right;
};

// Utility function to create a new node
Node* newNode(int data)
{
	Node* temp = new Node;
	temp->data = data;
	temp->left = temp->right = NULL;
	return (temp);
}

Node* buildTree(string str)
{
	// Corner Case
	if (str.length() == 0 || str[0] == 'N')
		return NULL;

	// Creating vector of strings from input
	// string after spliting by space
	vector<string> ip;

	istringstream iss(str);
	for (string str; iss >> str; )
		ip.push_back(str);

	// Create the root of the tree
	Node* root = newNode(stoi(ip[0]));

	// Push the root to the queue
	queue<Node*> queue;
	queue.push(root);

	// Starting from the second element
	int i = 1;
	while (!queue.empty() && i < ip.size()) {

		// Get and remove the front of the queue
		Node* currNode = queue.front();
		queue.pop();

		// Get the current node's value from the string
		string currVal = ip[i];

		// If the left child is not null
		if (currVal != "N") {

			// Create the left child for the current node
			currNode->left = newNode(stoi(currVal));

			// Push it to the queue
			queue.push(currNode->left);
		}

		// For the right child
		i++;
		if (i >= ip.size())
			break;
		currVal = ip[i];

		// If the right child is not null
		if (currVal != "N") {

			// Create the right child for the current node
			currNode->right = newNode(stoi(currVal));

			// Push it to the queue
			queue.push(currNode->right);
		}
		i++;
	}

	return root;
}


// } Driver Code Ends
//User function Template for C++

/*// A Tree node
struct Node
{
	int data;
	struct Node *left, *right;
};*/


class Solution
{
    public:
    
    /*You are required to complete below function */
   Node* solve(Node* root,int x,int y){
        while(root){
            if(root->data < x && root->data <y)
                root=root->right;
            else if(root->data > x && root->data >y) 
                root=root->left;
            else return root;
        }
        return root;
    }
    
    
    
    int kthCommonAncestor(Node *root, int k,int x, int y)
    {
        // O(h)----Find LCA iteratively
        Node* lca = solve(root,x,y);  
        
        
        // O(h) --- find distance b/w lca & root
        int dist=1;
        Node* temp=root;
        while(temp && temp!=lca){     
            dist++;
            if(temp->data > lca->data) temp=temp->left;
            else temp=temp->right;
        }
        
        // O(h) -- go from root towards lca (dist-k+1) steps
        temp=root;
        int d=1;
        while(temp && d<=dist){
            if(d==(dist-k+1)) return temp->data;
            d++;
            if(temp->data > lca->data) temp=temp->left;
            else temp=temp->right;
        }
        
        // ans not possible
        return -1;
    }

};



//{ Driver Code Starts.

int main ()
{

	int t;
	cin >> t;
	cin.ignore();

	while (t--)
	{
	
		string inp;
		getline(cin, inp);
		
		int k,x,y;
		cin>>k>>x>>y;
		cin.ignore();

		struct Node* root = buildTree(inp);

        Solution ob;
		int ans = ob.kthCommonAncestor(root,k,x,y);
		cout<<ans<<endl;

	}

	return 0;
}
// } Driver Code Ends