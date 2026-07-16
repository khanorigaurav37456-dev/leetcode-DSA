class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();

        
        for(int i = 0; i <s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == '*' ){
                stack.pop();
            } else{
                stack.push(ch);
                
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for(char ch : stack){
            sb.append(ch);
        }
        String string = sb.toString();

        return string;
    }
}