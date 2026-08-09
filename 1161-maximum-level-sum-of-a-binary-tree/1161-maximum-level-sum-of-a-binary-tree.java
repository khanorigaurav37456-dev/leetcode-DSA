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
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Long> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;

            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                sum += current.val;

                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
            map.put(level,sum);
            level++;
        }
        int bestLevel = -1;
        long bestSum = Long.MIN_VALUE;
        for(Map.Entry<Integer, Long> entry : map.entrySet()){
            int currentLevel = entry.getKey();
            Long currentSum = entry.getValue();

            if(currentSum > bestSum){
                bestSum = currentSum;
                bestLevel = currentLevel;
            }

            else if(currentSum == bestSum && currentLevel < bestLevel){
                bestLevel = currentLevel;

            }
        }
        return bestLevel;

    }
}