class Solution {
    public long sumAndMultiply(int n) {
       int non_zero = 0;
       int k = 1;
       int sum = 0;
        while(n!=0){
            int digit = n%10;
            if( digit != 0){
            non_zero = non_zero + k * digit;
            sum += digit;
            k *= 10;
            }
            n /= 10;
        }
        return (long) sum * non_zero;
    }
}