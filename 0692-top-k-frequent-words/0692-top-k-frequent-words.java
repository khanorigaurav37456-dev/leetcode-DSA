class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        for(String word : words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            } else{
                map.put(word,1);
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b)->{
            if(!map.get(a).equals(map.get(b))){
            return Integer.compare(map.get(a),map.get(b));
            }
            return b.compareTo(a);
        });

        for(String word : map.keySet()){
            minHeap.offer(word);

            if(minHeap.size()>k){
                minHeap.poll();            }
        }

        ArrayList<String> list = new ArrayList<>();

        while(!minHeap.isEmpty()){
            list.add(0,minHeap.poll());
        }
        return list;
    }
}