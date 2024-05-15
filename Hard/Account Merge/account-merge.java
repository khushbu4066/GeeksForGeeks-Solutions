//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends



class disjointSet{
ArrayList<Integer> rank = new ArrayList<>();
ArrayList<Integer> parent = new ArrayList<>();
ArrayList<Integer> size = new ArrayList<>();

public disjointSet(int n) {
	for(int i = 0 ;i <= n; i++) {
		rank.add(0);
		parent.add(i);
		size.add(1);
	}
}

public int findUpar(int node) {
	if(node == parent.get(node))
		return node;
	
	int ulp = findUpar(parent.get(node));
	parent.set(node, ulp);
	return parent.get(node);
	
}

public void unionByRank(int u, int v) {
	int ulp_u = findUpar(u);
	int ulp_v = findUpar(v);
	
	if(ulp_u == ulp_v)
		return;
	if(rank.get(ulp_v) < rank.get(ulp_u)) {
		parent.set(ulp_v, ulp_u);
	}
	else if(rank.get(ulp_v) > rank.get(ulp_u)) {
		parent.set(ulp_u, ulp_v);
	}
	else {
		parent.set(ulp_u, ulp_v);
		int rankU = rank.get(ulp_v);
		rank.set(rank.get(ulp_v),rankU+1);
	}
}

public void unionBySize(int u, int v) {
	int ulp_u = findUpar(u);
	int ulp_v = findUpar(v);
	
	if(ulp_u == ulp_v)
		return;
	
	if(size.get(ulp_u) < size.get(ulp_v)) {
		parent.set(ulp_u, ulp_v);
		size.set(ulp_v, size.get(ulp_v)+size.get(ulp_u));
	}
	else {
		parent.set(ulp_v, ulp_u);
		size.set(ulp_u, size.get(ulp_v)+size.get(ulp_u));
	}
	
	
}

}
class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
  
  int n = accounts.size();
  HashMap<String, Integer> mapMailNode = new HashMap<>();
  disjointSet ds = new disjointSet(n);
  
  for(int i = 0 ; i < n; i++){
      for(int j = 1; j < accounts.get(i).size(); j++){
          String mail = accounts.get(i).get(j);
          if(mapMailNode.containsKey(mail) == false)
          mapMailNode.put(mail, i);
          else
          ds.unionBySize(i, mapMailNode.get(mail));
          
      }
  }
  
  ArrayList<String>[] mergedMail = new ArrayList[n];
  
  for(int i = 0 ; i < n; i++){
      mergedMail[i] = new ArrayList<String>();
  }
  
  for(Map.Entry<String, Integer> map : mapMailNode.entrySet()){
      String mail = map.getKey();
      int node = ds.findUpar(map.getValue());
      mergedMail[node].add(mail);
      
  }
  
  List<List<String>> ans = new ArrayList<>();
  
  for(int i = 0 ; i < n; i++){
      if(mergedMail[i].size() == 0)
      continue;
      Collections.sort(mergedMail[i]);
      
      List<String> list = new ArrayList<>();
      list.add(accounts.get(i).get(0));
      
      for(String it : mergedMail[i]){
          list.add(it);
      }
      
      ans.add(list);
  }
  
  return ans;
  
  
  }
}
     