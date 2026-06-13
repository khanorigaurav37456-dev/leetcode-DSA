class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {

        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at current recursion level
            if (used.contains(nums[i])) {
                continue;
            }

            // Maintain non-decreasing order
            if (!path.isEmpty() &&
                nums[i] < path.get(path.size() - 1)) {
                continue;
            }

            used.add(nums[i]);

            path.add(nums[i]);           // Choose

            backtrack(nums, i + 1);      // Explore

            path.remove(path.size() - 1); // Unchoose
        }
    }
}