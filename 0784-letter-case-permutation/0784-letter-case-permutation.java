class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        solve("",s,0);
        return ans;
    }
    void solve(String currentString, String s, int index){
        if(index == s.length()){
            ans.add(currentString);
            return;
        }
        char ch = s.charAt(index);

        if(ch >=  'a' && ch <= 'z'|| ch>='A' && ch<='Z'){
            solve(currentString+Character.toUpperCase(ch), s,index+1);
            solve(currentString+Character.toLowerCase(ch),s,index+1);

        }
        if(ch>='0' && ch <= '9'){
            solve(currentString+ch,s,index+1);
        }
        return;
    }
}