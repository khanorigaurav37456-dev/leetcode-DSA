class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        solve(0,new ArrayList<>(),s);
        return ans;
    }
    void solve(int index, List<String> list, String s){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        int start = index;
        for(int end = start; end<s.length(); end++){
            if(isPalindrome(s,index,end)){
                list.add(s.substring(index,end+1));
                solve(end+1,list,s);
                list.remove(list.size()-1);
            }
    }
}
    boolean isPalindrome(String s, int left, int right) {

    while (left < right) {

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}}