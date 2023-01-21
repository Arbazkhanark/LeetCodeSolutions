//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    
    public static Boolean isPossible(int arr[],int mid,int totalCow){
        int cow=1;
        int lastPosition=arr[0]; // Cow placed at lastPosition (First cow always on [0] index  And Others will be Updated)


    /////////   Tracking the Current Position   
        for(int currentPosition=1;currentPosition<arr.length;currentPosition++){
            
            ////// Positioning Cows in stalls(Walls).....
            // if Start is less or Equal to (current-previousPosition)
                if(mid<=arr[currentPosition]-lastPosition){
                    cow++;
                    lastPosition=arr[currentPosition];
                    if(cow==totalCow){
                        return true;
                    }
                }
        }

        return false;
    }
    
    
    ///////////////////////  Implementing Binary Search      /////////////////////////////////
    public static int solve(int n, int totalCow, int[] arr) {

    //// an Array Sort 
        Arrays.sort(arr);

        
        int start=0;
        int end=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>end){
                end=arr[i];
            }
        }

        int res=-1;
        while(start<=end){
            /// Finding Mid
            int mid=(start+end)/2;
        
        ///// Checking if Position is posible
            if(isPossible(arr, mid, totalCow)){
                res=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return res;
    }

}