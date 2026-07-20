class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i =0; i< n; i++){
            arr[i] = -1;
        }
        for(int i = 0; i <2*n ; i++){
            while(!stack.isEmpty() && nums[stack.peek() % n] < nums[i % n]){
                int removed = stack.pop();
                arr[removed] = nums[i%n];   
            }     
            if (i < n) {
        stack.push(i);
    }
        }
        return arr;
        
    }
}