//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/
class Solution{
    
    // Height of Nodes
    public int height(Node root){
        if(root==null)return 0;
        
        return root.height;
    }
    
    // Finding the Max Height of Tree
    public int Maxheight(Node root){
        if(root==null)return 0;
        
        return Math.max(height(root.left),height(root.right))+1;
    } 
    
    
    //Finding the Balances of Nodes
    public int getBalance(Node root){
        if(root==null)return 0;
        
        return height(root.left)-height(root.right);
    }
    
    //Right Rotation
    public Node rightRotation(Node root){
        if(root==null)return null;
        
        Node curr=root.left;
        Node temp=curr.right;
        
        curr.right=root;
        root.left=temp;
        
        root.height=Maxheight(root);
        curr.height=Maxheight(curr);
        
        return curr;
    }
    
    //LEFT Rotation
    public Node leftRotation(Node root){
        if(root==null)return null;
        
        Node curr=root.right;
        Node temp=curr.left;
        
        curr.left=root;
        root.right=temp;
        
        root.height=Maxheight(root);
        curr.height=Maxheight(curr);
        
        return curr;
    }
    
    
    
    public  Node insertToAVL(Node root,int data){
        
        // Insert Nodes into BST
        Node insert=new Node(data);
        if(root==null)return insert;
        
        // Node curr=root;
        if(root.data > data){
            root.left=insertToAVL(root.left,data);
        }else if(root.data < data){
            root.right=insertToAVL(root.right,data);
        }
        
        root.height= Maxheight(root);

        
        int balance=getBalance(root);

        // CASE:--LEFT LEFT 
        if(balance >1 && data<root.left.data){
            return rightRotation(root);
        }
        
        // CASE:--RIGHT RIGHT
        if(balance <-1 && data>root.right.data){
            return leftRotation(root);
        }
    
        //CASE:--LEFT RIGHT
        if(balance >1 && data>root.left.data){
            root.left=leftRotation(root.left);
            return rightRotation(root);
        }
        
        // CASE:-- RIGHT LEFT
        if(balance< -1 && data <root.right.data){
            root.right=rightRotation(root.right);
            return leftRotation(root);
        }
     return root;
    }
}    




















