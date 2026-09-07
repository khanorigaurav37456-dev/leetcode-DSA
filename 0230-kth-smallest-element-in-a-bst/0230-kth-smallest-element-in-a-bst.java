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
    int ans = 0;
    int k;
    public int kthSmallest(TreeNode root, int k) {
      this.k = k;

      helper(root);
      return ans; 
    }
    void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        k--;
        if(k == 0){
            ans = node.val;
            return;
        }
        helper(node.right);
    }
}