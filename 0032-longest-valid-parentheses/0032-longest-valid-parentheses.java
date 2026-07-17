class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int currentLength = 0;
        int maxLength = 0;

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == '('){
                stack.push(i);
            } else if(!stack.isEmpty() && ch ==')'){
                stack.pop();
                if(!stack.isEmpty()){
                currentLength = i - stack.peek();
                maxLength = Math.max(currentLength,maxLength);
                }else if(stack.isEmpty() && ch == ')'){
                stack.push(i);
            }
            } 
        }
        return maxLength;
    }
}