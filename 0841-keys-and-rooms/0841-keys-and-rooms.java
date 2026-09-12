class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int key : rooms.get(current)){
                if(!visited[key]){
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }
        for(boolean room : visited){
            if(!room){
                return false;
            }
        }
        return true;
        
    }
}