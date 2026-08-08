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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int levelCount = 0;

        while(!queue.isEmpty()){
            
            int size = queue.size();
            long sum = 0;

            for(int i =0; i<size;i++){
                TreeNode current = queue.poll();

                sum += current.val;

                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
                
            }
            levelCount++;
            minHeap.offer(sum);

            if(minHeap.size() > k){
                minHeap.poll();
            }
            
        }
        if(levelCount<k){
                return -1;
            }
        return minHeap.peek();
    }
}