class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i<n; i++){
            int source = i + n;
            int destination = 2*i+1;
            int temp = nums[source];

            for(int j = source; j>destination; j--){
                nums[j] = nums[j-1];
            }
            nums[destination] = temp;
        }
        return nums;
    }
}