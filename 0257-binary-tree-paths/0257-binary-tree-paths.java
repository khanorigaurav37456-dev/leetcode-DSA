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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root,String.valueOf(root.val),list);
        return list;
    }
    void helper(TreeNode root, String path, List<String> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(path);
            return;
        }
        if(root.left != null){
        helper(root.left, path+"->"+root.left.val,list);
        } if(root.right != null){
        helper(root.right, path+"->"+root.right.val,list);
        }
    }
}