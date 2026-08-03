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
    TreeNode prev;
        int count;
        int maxCount;
        List<Integer> list= new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[list.size()];

        for(int i =0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        if(prev != null && prev.val == root.val){
            count++;
        } else{
            count=1;
        }

        if(count>maxCount){
            list.clear();
            list.add(root.val);
            maxCount = count;
        } else if(count ==maxCount){
            list.add(root.val);
        }

        prev = root;

        inorder(root.right);
    }
}