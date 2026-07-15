class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        int x = 0;

        for(int i =0; i< nums1.length; i++){
            int answer = -1;
            for(int j = 0; j< nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    stack.push(nums2[j]);
                    
                    for(int k = j + 1; k < nums2.length; k++){
                        if(nums2[k] > stack.peek()){
                            answer = nums2[k];
                            break;   
                        }   
                    } 
                }  
            }
            arr[x] = answer;
            x++;
        }
        return arr;
    }
}