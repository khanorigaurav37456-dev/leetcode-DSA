class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] start = {1,2,3,4,5,6,7,8,9};
        solve(start, 0, k , n, new ArrayList<>());
        return ans;
    }
    void solve(int[] start,int index,int  k,int  n,List<Integer> list){
        if(n == 0 && k ==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(n <0 || index == start.length){
            return;
        }

        list.add(start[index]);
        solve(start, index+1,k-1,n - start[index], list);
        list.remove(list.size()-1);

        solve(start, index +1, k , n, list);
        return;
    }
}