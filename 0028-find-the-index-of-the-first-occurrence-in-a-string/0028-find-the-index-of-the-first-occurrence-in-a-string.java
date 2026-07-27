class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int start = 0; start<=haystack.length() - needle.length(); start++){
            int i = start;
            int j =0;

            while(i<haystack.length() && j<needle.length()&& haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                
            }
            if(j == needle.length()){
            return start;
            }
        }
        return -1;
    }
}