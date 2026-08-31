class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;;

        int left = 0;
        int sum = 0;

        for(int right =0; right<nums.length; right++){
            sum = sum + nums[right];
            if(right - left + 1 == k){
                double average = (double) sum / k;
                max = Math.max(max,average);
                sum = sum - nums[left];
                left++;
            }
        }
        return max;
    }
}