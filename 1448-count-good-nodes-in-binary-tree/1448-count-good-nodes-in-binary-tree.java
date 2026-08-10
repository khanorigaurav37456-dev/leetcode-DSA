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
    public int goodNodes(TreeNode root) {
        return helper(root,root.val);
    }
    int helper(TreeNode root,int max){
        if(root == null){
            return 0;
        }
        int current = 0;

        if(root.val >= max){
            current += 1;
        }
        int newMax = Math.max(max,root.val);
        int left = helper(root.left,newMax);
        int right = helper(root.right,newMax);

        return current + left + right;
    }
}