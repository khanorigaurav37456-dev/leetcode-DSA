class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums,0,0,target);
    }
    int count(int[] nums, int index,int currentsum, int target){
        if(index == nums.length){
            if(currentsum  == target){
                return 1;
            } else{
                return 0;
            }

           
        }
         return count(nums, index+1, currentsum + nums[index], target) + count(nums, index+1, currentsum - nums[index], target);
        
    }
}