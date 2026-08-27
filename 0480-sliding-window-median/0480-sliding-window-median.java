class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->{
            return Integer.compare(b,a);
        });
        PriorityQueue<Integer> right = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        double[] result = new double[nums.length - k +1];

        int leftIndex = 0;
        int resultIndex = 0;
        int leftSize = 0;
        int rightSize =0;

        for(int rightIndex= 0; rightIndex < nums.length; rightIndex++){

            if(left.isEmpty() || nums[rightIndex] <= left.peek()){
                left.offer(nums[rightIndex]);
                leftSize++;
            } else{
                right.offer(nums[rightIndex]);
                rightSize++;
            }

            if(leftSize > rightSize+1){
                right.offer(left.poll());
                leftSize--;
                rightSize++;
            }
            if(rightSize>leftSize){
                left.offer(right.poll());
                leftSize++;
                rightSize--;
            }

            if(rightIndex - leftIndex + 1 == k){
                clean(left, map);
                clean(right, map);
                if(leftSize>rightSize){
                    result[resultIndex] = left.peek();
                } else{
                    result[resultIndex] = ((double) left.peek() + right.peek()) /2.0;
                }
                resultIndex++;
            
            int old = nums[leftIndex];

            if(map.containsKey(old)){
                map.put(old,map.get(old)+1);
            } else{
                map.put(old,1);
            }
            if (old <= left.peek()) {
               leftSize--;
            } else {
               rightSize--;
            }
            if(leftSize > rightSize+1){
                right.offer(left.poll());
                leftSize--;
                rightSize++;
            }
            if(rightSize>leftSize){
                left.offer(right.poll());
                leftSize++;
                rightSize--;
            }

            leftIndex++;
        }
        }
        return result;

    }
    private void clean(PriorityQueue<Integer> heap, HashMap<Integer,Integer> deleted){
        while(!heap.isEmpty() && deleted.containsKey(heap.peek())){
            int num = heap.poll();

            deleted.put(num,deleted.get(num) -1);

            if(deleted.get(num) == 0){
                deleted.remove(num);
            }
        }
    }
}