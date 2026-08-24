class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            } else{
                map.put(ch,1);
            }
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) ->{
            return Integer.compare(
                map.get(b),map.get(a)
            );
        });
        for(Character ch : map.keySet()){
            heap.offer(ch);
        }

        StringBuilder string = new StringBuilder();

        Character previous = null;

        while(!heap.isEmpty()){
            char ch = heap.poll();

            string.append(ch);

            map.put(ch,map.get(ch) -1);

            if(previous != null && map.get(previous) > 0){
                heap.offer(previous);
            }
             previous = ch;
        }

        if (string.length() != s.length()) {
         return "";
}
        return string.toString();

    }
}