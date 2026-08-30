class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        int deletion = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        int option1 = Math.max(minIndex,maxIndex) + 1;
        int option2 = nums.length - Math.min(minIndex,maxIndex);
        int option3 = minIndex + 1 + nums.length - maxIndex;
        int option4 = maxIndex + 1 + nums.length - minIndex;

        return Math.min(Math.min(option1,option2), Math.min(option3,option4));

        
            
    }
}