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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val > key){
            TreeNode left = deleteNode(root.left,key);
            root.left = left;
        } else{
            TreeNode right = deleteNode(root.right,key);
            root.right =  right;
        }

        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null && root.right != null){
                return root.right;
            } else if(root.right == null && root.left != null){
                return root.left;
            }
             else {
                TreeNode successor = root.right;

                while(successor.left != null){
                    successor = successor.left;
                }
                root.val = successor.val;
                root.right = deleteNode(root.right,successor.val);
            }
        }
        return root;
    }
}