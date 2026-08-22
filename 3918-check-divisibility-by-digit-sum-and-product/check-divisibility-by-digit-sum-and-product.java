class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int sum = 0;
        int product = 1;
        while(original > 0){
            int digit = original % 10;
            sum += digit;
            product *= digit;
            original /= 10;
        }
        int add = sum + product;
        if(add == 0){
            return false;
        }
        return n%add==0;
    }
}