/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans=new ArrayList<>();  //[[3],[9,20],[15,7]]
        Queue<TreeNode> q=new LinkedList<>();

        ArrayList<Integer> currList=new ArrayList<>();
        
        if(root==null)return ans;
        
        q.add(root);                             
        q.add(null);
        while(!q.isEmpty()){
          TreeNode curr =q.poll(); 
            if(curr==null){
                ans.add(currList);
                
                if(q.isEmpty())return ans;
                
                q.add(null);
                currList=new ArrayList<Integer>();
            }else{
                currList.add(curr.val);              
                if(curr.left!=null)q.add(curr.left);
                
                if(curr.right!=null)q.add(curr.right);
            }

        }
        return ans;
    }
}