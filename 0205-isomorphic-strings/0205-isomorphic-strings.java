class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapst = new HashMap<>();
        HashMap<Character,Character> mapts = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(mapst.containsKey(a) && mapst.get(a) != b){
                return false;
            }
            if(mapts.containsKey(b) && mapts.get(b) != a){
                return false;
            }

            mapst.put(a,b);
            mapts.put(b,a);
            
        }
        return true;
    }
}