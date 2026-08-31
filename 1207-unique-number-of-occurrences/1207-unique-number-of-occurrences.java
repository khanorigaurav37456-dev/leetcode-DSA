class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else{
                map.put(num,1);
            }
        }
        HashSet<Integer> set = new HashSet<>();

        for(int val : map.values()){
            if(set.contains(val)){
                return false;
            }
            set.add(val);
        }
        return true;
    }
}