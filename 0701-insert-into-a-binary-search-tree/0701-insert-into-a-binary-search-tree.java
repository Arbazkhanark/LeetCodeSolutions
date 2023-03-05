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
    public TreeNode insertIntoBST(TreeNode root, int key) {
        
        TreeNode curr=root;
        TreeNode parent=null;
        while(curr!=null){
            if(curr.val < key){
                parent=curr;
                curr=curr.right;
            }else if(curr.val > key){
                parent=curr;
                curr=curr.left;
            }
        }
        
        TreeNode newNode =new TreeNode(key);
        if(parent==null)return newNode;
        
        if(parent.val > key){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        
        return root;
    }
}