class Solution {
    public int[] twoSum(int[] arr, int target) {

            int b[]=new int[2];
            int temp=0;
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]+arr[j]==target){
                        b[temp++]=i;
                        System.out.println(b[0]);
                        b[temp++]=j;
                        System.out.println(b[1]);
                    }
                }
            }
            return b;
    }
}