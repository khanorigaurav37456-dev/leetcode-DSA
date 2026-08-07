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

    List<Integer> inorder = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        sortedArray(root);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<queries.size(); i++){
            List<Integer> temp = new ArrayList<>();
            int floor = -1;
            int ceil = -1;

            int low = 0;
            int high = inorder.size()-1;
            while(low<=high){

            int mid = (low+high)/2;

            int value = inorder.get(mid);
            
            if(value == queries.get(i)){
                floor = value;
                ceil = value;
                break;
            }
            if(value < queries.get(i)){
                 floor = value;
                 low = mid+1;
            } else{
                 ceil = value;
                high = mid-1;
            }     
            }
            temp.add(floor);
            temp.add(ceil);
            result.add(temp);
        }
        return result;
    }
    void sortedArray(TreeNode root){
        if(root == null){
            return;
        }

        sortedArray(root.left);
        inorder.add(root.val);
        sortedArray(root.right);
    }
}