//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}
// } Driver Code Ends


class Solution
{
    static int find_height(int tree[], int n, int k)
    {
        //Highest Tree From the Array
        int high=0;
        for(int i=0;i<tree.length;i++){
            if(tree[i]>high){
                high=tree[i];
            }
        }
        
        
        //// Machine will Check Its Height if Height Set to the Total-Collection(k) of Wood
        for(int machine_height=0;machine_height<high;machine_height++){
            int wood_collection=0;
            
            ////Height of tree will cut => if tree height is greater than Machine-height
            for(int tre=0;tre<n;tre++){
                if(machine_height<tree[tre]){
                    wood_collection+=tree[tre]-machine_height;
                }
            }
            
            //// Wood collection to that height is same than the Machine Height is Accurate There..
            if(wood_collection==k){
                return machine_height;
            }
        }
        return -1;
    }
}