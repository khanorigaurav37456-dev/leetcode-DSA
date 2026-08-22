class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int prod = 1;

        while(n>0){
            int modu = n%10;
            sum = sum+modu;
            prod = prod*modu;
            n = n/10;
        }
        return num % (sum + prod) == 0;
    }
}