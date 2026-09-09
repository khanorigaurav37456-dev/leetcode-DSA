class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long total = 0;
       PriorityQueue<int[]> leftheap = new PriorityQueue<>((a,b) -> {
        if(a[0] == b[0]){
            return Integer.compare(a[1],b[1]);
        }
        return Integer.compare(a[0],b[0]);
       });
       PriorityQueue<int[]> rightheap = new PriorityQueue<>((a,b) -> {
        if(a[0] == b[0]){
            return Integer.compare(a[1],b[1]);
        }
        return Integer.compare(a[0],b[0]);
       });

       int left = 0;
       int right = costs.length-1;

       for(int i =0; i<candidates && left<=right; i++){
        leftheap.offer(new int[]{costs[left],left});
        left++;
       }
       for(int j =0; j<candidates && left<=right; j++){
        rightheap.offer(new int[]{costs[right],right});
        right--;
       }

       for(int x =0; x<k; x++){
        if(leftheap.isEmpty()){
            int[] ans = rightheap.poll();
            total += ans[0];
            if(left<=right){
                rightheap.offer(new int[]{costs[right],right});
                right--;
            }
        } else if(rightheap.isEmpty()){
            int[] ans = leftheap.poll();
            total += ans[0];

            if(left <= right){
            leftheap.offer(new int[]{costs[left],left});
            left++;
            }
        }
        else if(leftheap.peek()[0] < rightheap.peek()[0]){
            int[] ans = leftheap.poll();
            total += ans[0];

            if(left <= right){
            leftheap.offer(new int[]{costs[left],left});
            left++;
            }
        }else if(leftheap.peek()[0] > rightheap.peek()[0]){
            int[] ans = rightheap.poll();
            total += ans[0];
            if(left<=right){
                rightheap.offer(new int[]{costs[right],right});
                right--;
            }
        }
         else {
            if(leftheap.peek()[1] < rightheap.peek()[1]){
                int[] ans = leftheap.poll();
                total += ans[0];

                if(left <= right){
                    leftheap.offer(new int[]{costs[left],left});
                    left++;
                } 
                }else{
                    int[] ans = rightheap.poll();
                    total += ans[0];

                    if(left<=right){
                        rightheap.offer(new int[]{costs[right],right});
                        right--;
                    }
                }
            
        }
       }
       return total;
    }
}