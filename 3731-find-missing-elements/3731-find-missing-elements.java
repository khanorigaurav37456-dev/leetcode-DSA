class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];

        int expected = min;
        int j = 0;

        while(expected<=max){
            if(expected == nums[j]){
                j++;
            } else{
                list.add(expected);
            }
            expected++;
        }
        
        return list;
    }
}