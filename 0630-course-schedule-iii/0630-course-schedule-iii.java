class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->  Integer.compare(b,a));

        int currentSum = 0;

        for(int[] course : courses){
            int duration = course[0];
            int lastDay = course[1];

            if(currentSum + duration <= lastDay){
                currentSum += duration;
                heap.offer(duration);
            } else if(!heap.isEmpty() && heap.peek() > duration){
                currentSum -= heap.poll();
                heap.offer(duration);
                currentSum += duration;

            }

        }
        return heap.size();
    }
}