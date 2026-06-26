class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve("",0,0,n);
        return ans;
    }
    void solve(String str, int open, int close, int n){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }
        if(open < n){
            solve(str + "(",open+1,close,n);
        }
        if(close<open){
            solve(str + ")",open,close+1,n);
        }
        return;
    }
}