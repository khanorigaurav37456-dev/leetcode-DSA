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
    class Info{
        boolean isBst;
        int sum;
        int min;
        int max;

        Info(boolean isBst,int sum,int min,int max){
            this.isBst = isBst;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    int max = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }
    Info dfs(TreeNode root){
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        boolean isBst = left.isBst && right.isBst && left.max < root.val && root.val < right.min;

        int sum = root.val + left.sum + right.sum;

        if(isBst){
            max = Math.max(max,sum);
        }
        int min = Math.min(root.val, Math.min(left.min,right.min));
        int maxValue = Math.max(root.val, Math.max(left.max,right.max));

        return new Info(isBst,sum,min,maxValue);
    }
}