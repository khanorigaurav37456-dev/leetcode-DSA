class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : word1.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char c : word2.toCharArray()){
            if(map2.containsKey(c)){
                map2.put(c,map2.get(c) + 1);
            }else{
                map2.put(c,1);
            }
        }

        for(char c : map.keySet()){
            if(!map2.containsKey(c)){
                return false;
            }
        }
        ArrayList<Integer> list1 = new ArrayList<>(map.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}