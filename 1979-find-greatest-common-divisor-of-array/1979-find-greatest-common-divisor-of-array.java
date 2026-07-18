class Solution {
    public int findGCD(int[] nums) {
        int small = nums[0];
        int big = nums[0];

        for(int i =1; i<nums.length; i++){
            if(nums[i] > big){
                big = nums[i];
            } else if(nums[i]<small){
                small = nums[i];
            }
        }
        return gcd(small,big);
    }
    static int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;

        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }
}