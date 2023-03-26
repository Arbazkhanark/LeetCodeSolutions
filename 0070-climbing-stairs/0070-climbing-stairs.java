class Solution {
   
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        Arrays.fill(arr,-1);
        
        return arrUpdate(n,arr);
    }
    
    public static int arrUpdate(int n, int dp[]){
        
        if(dp[n]!=-1)return dp[n];
        if(n<=2){
            return dp[n]=n;
        }
        
        return dp[n]=arrUpdate(n-1,dp)+arrUpdate(n-2,dp);
    }
}