class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int start = 0; start<haystack.length(); start++){
            int i = start;
            int j =0;

            while(i<haystack.length() && j<needle.length()){
                if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                } else{
                    break;
                }
            }
            if(j == needle.length()){
            return start;
            }
        }
        return -1;
    }
}