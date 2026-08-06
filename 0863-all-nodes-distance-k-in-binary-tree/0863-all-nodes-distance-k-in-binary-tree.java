/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        MapHelper(root,null);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            if(distance == k){
                break;
            }
            for(int i=0; i<size; i++){
                TreeNode  current = queue.poll();
                TreeNode par = parent.get(current);
                if(current.left != null && !visited.contains(current.left)){
                queue.offer(current.left);
                visited.add(current.left);
}
                 if(current.right != null && !visited.contains(current.right)){
                queue.offer(current.right);
                visited.add(current.right);
}
                if(par != null && !visited.contains(par)){
                    queue.offer(par);
                    visited.add(par);
                }
            }
            distance++;
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
        }
        return list;



    }
    void MapHelper(TreeNode root, TreeNode parentNode){
        if(root == null){
            return;
        }
        parent.put(root,parentNode);
        MapHelper(root.left,root);
        MapHelper(root.right,root);
    }
}