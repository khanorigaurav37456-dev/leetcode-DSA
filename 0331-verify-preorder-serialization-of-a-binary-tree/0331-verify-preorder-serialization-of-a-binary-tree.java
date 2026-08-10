class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1;

        for(int i=0; i<nodes.length; i++){
            if(slots == 0){
                return false;
            }

            if(nodes[i].equals("#")){
                slots--;
            } else{
                slots++;
            }
        }
        if(slots == 0){
            return true;
        } else{
            return false;
        }
    }
}