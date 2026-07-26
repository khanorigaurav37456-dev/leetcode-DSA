class Solution {
    public int compress(char[] chars) {
        int k = 0;
        int i = 0;
        int j = 0;
        
        while(i<chars.length){
            while(j+1 <chars.length && chars[i] == chars[j+1]){
                j++;
            } 
                chars[k] = chars[i];
                k++;
                int count = j-i+1;
                if(count >1){
                String str = Integer.toString(count);
                for(int x = 0; x<str.length(); x++){
                    chars[k] = str.charAt(x);
                    k++;
                }
                }
            
            i = j+1;
            j = i;
            
        }

        return k;
        
    }
}