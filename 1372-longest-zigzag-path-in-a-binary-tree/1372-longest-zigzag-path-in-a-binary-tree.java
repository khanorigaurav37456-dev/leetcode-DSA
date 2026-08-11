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
    int answer = 0;
    public int longestZigZag(TreeNode root) {
        path(root,"left",0);
        path(root,"right",0);
        return answer;
    }
    int path(TreeNode root, String direction, int length){
        if(root == null){
            return 0;
        }
        answer = Math.max(answer,length);

        if(direction.equals("left")){
            if(root.left != null){
                path(root.left,"right",length+1);  
            } 
            if(root.right != null){
                path(root.right,"left",1);
            }
        }
        if(direction.equals("right")){
            if(root.right != null){
                path(root.right,"left",length+1); 
            } 
            if(root.left != null){
                path(root.left,"right",1);
            }
        }

        return answer;

    }
}