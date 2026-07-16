class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackNum = new Stack<Integer>();
        Stack<String> stackString = new Stack<String>();
        StringBuilder sb = new StringBuilder();

        int currentNum = 0;
        String currentString = "";

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currentNum = currentNum*10+(ch - '0');
            } else if(Character.isLetter(ch)){
                currentString = currentString + ch;

            }else if(ch == '['){
                stackNum.push(currentNum);
                currentNum = 0;
                stackString.push(currentString);
                currentString = "";
            } else if(ch == ']'){
                int repeat = stackNum.pop();
                String decode = "";
                for(int j =0; j<repeat; j++){
                     decode = decode + currentString;
                }
                String previous = stackString.pop();
                currentString = previous + decode;
                

            }
        }
        return currentString;
    }
}