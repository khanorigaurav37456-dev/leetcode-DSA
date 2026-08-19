class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for(int j = 0; j<nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }

        for(int x = i; x < nums.length; x++){
            nums[x] = 0;
            i++;
        }
    }
}