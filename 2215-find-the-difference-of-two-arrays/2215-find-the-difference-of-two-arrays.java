class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }

        for(int num : set1){
            if(!set2.contains(num)){
                first.add(num);
            }
        }
        list.add(first);
        for(int num : set2){
            if(!set1.contains(num)){
                second.add(num);
            }
        }
        list.add(second);
        return list;
    }
}