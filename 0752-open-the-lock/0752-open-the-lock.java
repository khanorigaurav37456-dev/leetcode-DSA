class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for(String s:deadends){
            dead.add(s);
        }
        if(dead.contains("0000")){
           return -1;
        }
        if(target.equals("0000")){
            return 0;
        }
        queue.offer("0000");
        visited.add("0000");
        int distance =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int level =0; level<size; level++){
                String current = queue.poll();
                char[] chars = current.toCharArray();
                for(int i=0; i<4; i++){
                    int digit = chars[i] - '0';
                    int plus = (digit + 1) % 10;
                    int minus = (digit + 9) % 10;
                    chars[i] = (char)(minus + '0');
                    String neigh = new String(chars);

                    if(!dead.contains(neigh) && !visited.contains(neigh)){
                        if(neigh.equals(target)){
                            return distance + 1;
                        }
                        queue.offer(neigh);
                        visited.add(neigh);
                    }
                    chars[i] = (char)(plus + '0');
                    neigh = new String(chars);


                    if(!dead.contains(neigh) && !visited.contains(neigh)){
                        if(neigh.equals(target)){
                            return distance + 1;
                        }
                        queue.offer(neigh);
                        visited.add(neigh);
                    }
                    chars[i] = (char)(digit + '0'); 
                }
            }
            distance++;
        }
        return -1;
    }
}