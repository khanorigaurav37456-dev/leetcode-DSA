class Solution {
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];

        for(int x = 1; x < nums.length; x++){
            arr[x] = arr[x-1] + nums[x];
        }

        return arr;
    }
}