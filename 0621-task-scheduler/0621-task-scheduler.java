class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char task : tasks){
            if(map.containsKey(task)){
                map.put(task,map.get(task) + 1);
            } else{
                map.put(task,1);
            }
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) ->{
            return Integer.compare(
                map.get(b),map.get(a)
            );
        });

        for(Character task : map.keySet()){
            heap.offer(task);
        }
        int time = 0;
        int cycle = n + 1;

        while(!heap.isEmpty()){
            int used =0;
            List<Character> temp = new ArrayList<>();
            for(int i =0; i<cycle; i++){
                if(!heap.isEmpty()){
                    char task = heap.poll();
                    map.put(task,map.get(task) -1);
                    temp.add(task);
                    used++;
                } 
            }

            for(Character task : temp){
                if(map.get(task)>0){
                    heap.offer(task);
                }
            }
            if(!heap.isEmpty()){
                time = time +  cycle;
            } else{
                time = time + used;
            }
        }
        return time;
    }
}