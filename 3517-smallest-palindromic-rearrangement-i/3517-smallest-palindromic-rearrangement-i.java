class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(int i =0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = '\0';
        for(int i =0; i<26; i++){
            for(int j=0; j<freq[i]/2; j++){
                left.append((char)('a' + i));
            }

                if(freq[i]%2 != 0){
                    middle = (char)('a'+i);
                }
            
        }
            String right= new StringBuilder(left).reverse().toString();


            String ans;

            if(middle == '\0'){
                ans = left.toString() + right;
            } else{
                ans = left.toString() + middle + right;
            }
            return ans;
        }
    
}