class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permutations(new ArrayList<>(), nums, 0);
    }
    List<List<Integer>> permutations(List<Integer> p, int[] nums, int index){
        // base condition
        if(index == nums.length){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(p));
            return list;
        }
        int current = nums[index];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i <=p.size(); i++){
            List<Integer> temp = new ArrayList<>(p);
            temp.add(i,current);

            ans.addAll(permutations(temp, nums, index +1));
        }
        return ans;
    }
}