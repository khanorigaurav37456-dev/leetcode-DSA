class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> mapRev = new HashMap<>();

        String[] words = s.split(" ");
        char[] ch = pattern.toCharArray();
        if(pattern.length() != words.length){
            return false;
        }

        for(int i = 0; i<words.length; i++){
            if(map.containsKey(ch[i])){
                if(!map.get(ch[i]).equals(words[i])){
                    return false;
                }
            }  else{
                map.put(ch[i],words[i]);
            }

            if(mapRev.containsKey(words[i])){
                if(!mapRev.get(words[i]).equals(ch[i])){
                    return false;
                }
            } else{
                mapRev.put(words[i],ch[i]);
            }
        }
        return true;
    }
}