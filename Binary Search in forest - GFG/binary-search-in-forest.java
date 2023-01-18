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
    ////////////  Using Binary Search    ////////////////
    static int find_height(int tree[], int n, int k)
    {
        
        //// It finds the Highest Tree From Array
        Arrays.sort(tree);
        int start=0;
        int end=tree[n-1];
        // for(int j=0;j<tree.length;j++){
        //     if(tree[j]>end){
        //         end=tree[j];
        // }
        
        while(start<=end){
            int machine_Height=(start+end)/2;  /////   (Binary Search)
                
///// It will Collect the Woods                
                int wood_collection=0;
                for(int i=0;i<tree.length;i++){
                    if(machine_Height<tree[i]){
                        wood_collection+=tree[i]-machine_Height;
                    }
                }


////// This will check the Machine_Height Acc to Wood Required
                if(wood_collection==k){
                    return machine_Height;
                }else if(wood_collection>k){
                    start=machine_Height+1;
                }else{
                    end=machine_Height-1;
                }
                
        }
    return -1;
    }
}