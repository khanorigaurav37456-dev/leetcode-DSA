class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(productOfDigits(n) % t == 0){
                return n;
            } 
                n++;        
        }
    }
    int productOfDigits(int number){
        int product = 1;

        while(number>0){
        product = product * (number%10);
        number = number /10;
        }

        return product;
    }
}