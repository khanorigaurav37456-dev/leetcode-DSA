class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int middle = Integer.MIN_VALUE;

        for(int i = nums.length-1; i >=0; i--){
            int current = nums[i];
            if(current<middle){
                return true;
            }
            while(!stack.isEmpty() && current > stack.peek()){
                middle = stack.pop();
            }
            stack.push(current);
        }
        return false;
    }
}