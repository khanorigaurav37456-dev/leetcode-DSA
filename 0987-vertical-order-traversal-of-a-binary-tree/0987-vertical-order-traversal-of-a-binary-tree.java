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
import java.util.AbstractMap;
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        int col = 0;

        Queue<Map.Entry<TreeNode,Integer>> queue = new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap();

        queue.offer(new AbstractMap.SimpleEntry<>(root,col));

        int min = 0;
        int max = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            Map<Integer,ArrayList<Integer>> levelMap =  new HashMap<>();

            for(int i=0; i<size; i++){
            Map.Entry<TreeNode,Integer> removed = queue.poll();
            TreeNode node = removed.getKey();
            col = removed.getValue();

            
                if(!levelMap.containsKey(col)){
                    levelMap.put(col,new ArrayList<>());
                }

                levelMap.get(col).add(node.val);

                min = Math.min(min,col);
                max = Math.max(max,col);

                if(node.left != null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.left,col-1));
                }

                if(node.right != null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.right,col+1));
                }
            }  
        

        for(ArrayList<Integer> list : levelMap.values()){
            Collections.sort(list);
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry : levelMap.entrySet()){
            int currentCol = entry.getKey();
            ArrayList<Integer> values = entry.getValue();
            if(!map.containsKey(currentCol)){
                map.put(currentCol, new ArrayList<>());
            }
            map.get(currentCol).addAll(values);
        }
        }
        for(int i = min; i<=max; i++){
            ans.add(map.get(i));
        }
        

        return ans;
    }
}