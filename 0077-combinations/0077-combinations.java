class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(1,n,k, new ArrayList<>());
        return ans;
    }
    void solve(int currentnum, int n,int k, List<Integer> list){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(currentnum > n ){
            return;
        }

        list.add(currentnum);
        solve(currentnum+1,n,k,list);
        list.remove(list.size()-1);
        solve(currentnum + 1,n, k,list);
        return;
    }
}