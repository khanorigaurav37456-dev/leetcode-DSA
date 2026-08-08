class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] hasParent = new boolean[n];

        for(int i =0; i<n; i++){
            if(leftChild[i] != -1){
                if(hasParent[leftChild[i]]){
                    return false;
            }
                hasParent[leftChild[i]] = true;
            }
            if(rightChild[i] != -1){
                    if(hasParent[rightChild[i]]){
                    return false;
            }
                hasParent[rightChild[i]] = true;
            }
        }
        int root = -1;
        for(int j = 0; j<hasParent.length; j++){
            if(!hasParent[j]){
                if(root != -1){
                    return false;
                }
                root = j;
            }
        }
        if(root == -1){
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;

            if(leftChild[current] != -1){
                queue.offer(leftChild[current]);
            }
             if(rightChild[current] != -1){
                queue.offer(rightChild[current]);
            }
        }
        return count == n;

    }
}