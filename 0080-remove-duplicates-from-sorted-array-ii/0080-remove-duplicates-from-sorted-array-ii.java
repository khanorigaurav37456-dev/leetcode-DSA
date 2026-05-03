class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <=2){
            return nums.length;
        }

        int k =2;

        for(int j = 2; j<nums.length; j++){
            if(nums[j] != nums[k-2]){
                nums[k] = nums[j];
                k++;
            }
        }
        return k;
    }
    
}