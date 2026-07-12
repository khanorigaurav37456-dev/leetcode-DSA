class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Previous '(' has received only one ')'
                if (stack.size() % 2 == 1) {
                    stack.pop();
                    count++;
                }

                // Every '(' needs two ')'
                stack.push(')');
                stack.push(')');

            } else {
                if (stack.isEmpty()) {
                    // Missing '('
                    count++;

                    // Inserted '(' needs two ')',
                    // current ')' satisfies one
                    stack.push(')');
                } else {
                    stack.pop();
                }
            }
        }

        return count + stack.size();
    }
}