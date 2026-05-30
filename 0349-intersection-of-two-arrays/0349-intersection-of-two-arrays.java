class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        int[] arr = new int[nums1.length];
        int k = 0;

        for(int i = 0; i<nums1.length; i++){
            for(int j =0; j<nums2.length; j++){

                if(nums1[i] == nums2[j]){
                    boolean Ispresent = false;
                    for(int x=0; x<k; x++){
                        if(arr[x] == nums1[i]){
                            Ispresent = true;
                        }
                    }
                    if(!Ispresent){
                    arr[k] = nums1[i];
                    k++;
                    }
                } 
            }
        }
        int[] result = new int[k];

for(int i = 0; i < k; i++) {
    result[i] = arr[i];
}

return result;
            
        }
        

    }
