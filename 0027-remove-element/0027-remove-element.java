class Solution {
    public int removeElement(int[] arr, int val) {
        
        int newIndex=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=val){
                arr[newIndex]=arr[i];
                newIndex++;
            }
        }
        
        return newIndex;
    }
}