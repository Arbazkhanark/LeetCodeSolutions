//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    public ArrayList<Integer> ListTree(Node root,ArrayList<Integer> ans){
        if(root==null)return ans;

        ListTree(root.left,ans);
        ans.add(root.data);
        ListTree(root.right,ans);
        
        return ans;
    }
    
    
    
    public int isPairPresent(Node root, int target){
        ArrayList<Integer> ans=new ArrayList<>();
        ListTree(root,ans);
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=0;i<ans.size();i++){
            set.add(ans.get(i));
        }
        
        for(int i=0;i<ans.size();i++){
            int sum=target-ans.get(i);
            if(set.contains(sum)){
                return 1;
            }
        }
        
        
        // for(int i=0;i<ans.size();i++){
        //     if(!map.isEmpty()){
        //         int value=target-map.get(i);
        //         map.put(ans.get(i),i);
        //         if(map.containsKey(value)){
        //             return 1;
        //         } 
        //     }
            
        //     if(map.isEmpty()){
        //         map.put(ans.get(i),i);
        //     }
            
        // }
        return 0;
        
        
    }
}
