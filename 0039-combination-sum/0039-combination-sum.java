class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] arr, int target) {
         solve(arr,0,target, new ArrayList<>());
        return ans;
        
    }
    void solve(int[]arr,int index, int target, List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target <0 || index == arr.length){
            return;
        }

        

        list.add(arr[index]);
        solve(arr,index, target - arr[index], list);
        list.remove(list.size()-1);

        solve(arr,index +1,target, list);

        return;
    }
}