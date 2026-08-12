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
    StringBuilder pathS =  new StringBuilder();
    StringBuilder pathD =  new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        helper(root,startValue,pathS);
        helper(root,destValue,pathD);
        int i = 0;
        while(i<pathS.length() && i<pathD.length() && pathS.charAt(i) == pathD.charAt(i)){
            i++;
        }
        StringBuilder answer = new StringBuilder();

        for(int j = i; j<pathS.length(); j++){
            answer.append("U");
        }
        answer.append(pathD.substring(i));
        return answer.toString();

        
    }
    boolean helper(TreeNode root, int value , StringBuilder path){
        if(root == null){
            return false;
        }

        if(root.val == value){
            return true;
        }
        path.append("L");
        boolean left = helper(root.left,value,path);
        if(left == true){
            return true;
        }
        if(left != true){
            path.deleteCharAt(path.length()-1);
        }

        path.append("R");
        boolean right = helper(root.right,value,path);
        if(right == true){
            return true;
        }
        if(right != true){
            path.deleteCharAt(path.length()-1);
        }

        return false;

    }
}