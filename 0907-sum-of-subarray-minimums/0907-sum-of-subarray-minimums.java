class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        long ans =0;
        int[] previous = prev(arr);
        int[] nextElement = next(arr);
        for(int i= 0; i<arr.length; i++){
            long left = i - previous[i];
            long right = nextElement[i] - i;
            ans += (long)arr[i] * left * right;
        }
         return (int)(ans % MOD);
    }
    public int[] prev(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        int [] previous = new int[arr.length];

        for(int i =0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            } 
            if(stack.isEmpty()){
                previous[i] = -1; 
            } else{
                previous[i] = stack.peek();
            }
            stack.push(i);
        }
        return previous;
    }
    public int[] next(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        int[] nextElement = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextElement[i] = arr.length;
            } else{
                nextElement[i] = stack.peek();
            }
            stack.push(i);
        }
        return nextElement;
    }
}