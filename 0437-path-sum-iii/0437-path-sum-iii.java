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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        long current = countFrom(root,targetSum);
        long left = pathSum(root.left,targetSum);
        long right = pathSum(root.right,targetSum);
        
        return (int)(current + left + right);
    }
    long countFrom(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }

        long current = (root.val == targetSum) ? 1:0;

       long left =  countFrom(root.left,targetSum - root.val);
       long right = countFrom(root.right,targetSum - root.val);

       return current + left + right;
    }
}