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
    class Pair {

    TreeNode node;
    long index;

    Pair(TreeNode node, long index){
        this.node = node;
        this.index = index;
    }
}
    public int widthOfBinaryTree(TreeNode root) {
        int  maxWidth = 0; 
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,1));
        while(!queue.isEmpty()){
            int size = queue.size();
            long first = queue.peek().index;
            long last = first;

            for(int i = 0; i<size;i++){
                Pair current  = queue.poll();
                last = current.index;

                if(current.node.left != null){
                    queue.offer(new Pair(current.node.left,current.index*2));
                }
                if(current.node.right != null){
                    queue.offer(new Pair(current.node.right,current.index*2+1));
                }
            }
                int width = (int)(last-first+1);
                maxWidth = Math.max(maxWidth, width);
            
        }

        return maxWidth;
    }
}