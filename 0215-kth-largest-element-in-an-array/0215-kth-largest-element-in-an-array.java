class Solution {
    public int findKthLargest(int[] nums, int k) {

        sort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            while (nums[s] < pivot) {
                s++;
            }

            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;

                s++;
                e--;
            }
        }

        sort(nums, low, e);
        sort(nums, s, high);
    }
}