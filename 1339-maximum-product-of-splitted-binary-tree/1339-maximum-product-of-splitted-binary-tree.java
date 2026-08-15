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
    long answer = 0;
    long total;
    public int maxProduct(TreeNode root) {
        total = totalSum(root);
        dfs(root);
        return (int)(answer % 1_000_000_007);
    }
    int totalSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = totalSum(root.left);
        int right = totalSum(root.right);

        return root.val + left + right;
    }

    long dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        long left = dfs(root.left);
        long right = dfs(root.right);

        long subTreeSum = root.val + left + right;
        
        long otherSide = total - subTreeSum;

        long product = subTreeSum * otherSide;

        answer = Math.max(answer,product);

        return subTreeSum;
    }
}