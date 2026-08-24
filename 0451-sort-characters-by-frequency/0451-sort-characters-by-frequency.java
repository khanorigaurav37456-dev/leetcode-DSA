class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            } else{
                map.put(ch,1);
            }
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(
                map.get(b),map.get(a)
            );
        });

        for(Character ch : map.keySet()){
            heap.offer(ch);
        }

        StringBuilder string = new StringBuilder();

        while(!heap.isEmpty()){
            char ch = heap.poll();

            for(int i=0; i<map.get(ch); i++){
                string.append(ch);
            }
        }
        return string.toString();

    }
}