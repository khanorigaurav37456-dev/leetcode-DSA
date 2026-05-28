class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;

            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);

                int len = j - i + 1;

                if (len >= l && len <= r && sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}