class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] last = new int[26];
        for(int i =0; i< s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26];

        for(int j =0; j<s.length(); j++){

            if(visited[s.charAt(j) - 'a']){
                continue;
            }
            while(!stack.isEmpty() && j < last[stack.peek()-'a'] && s.charAt(j) < stack.peek()){
                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            stack.push(s.charAt(j));
            visited[s.charAt(j) - 'a'] = true;

            }
            StringBuilder sb = new StringBuilder();

            while (!stack.isEmpty()) {
               sb.append(stack.pop());
            }

            return sb.reverse().toString();
        }

    }
