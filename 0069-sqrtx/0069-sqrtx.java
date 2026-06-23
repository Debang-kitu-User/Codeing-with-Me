class Solution {
    public int mySqrt(int x) {

        if(x<2) return x;

        int L = 1;
        int R = x/2;

        while(L <= R){
            int M = L + (R-L) / 2;
            long M_square = (long) M*M;

            if(M_square  == x){
                return M;
            }else if(M_square < x){
                L = M+1;
            }else{
                R = M-1;
            }
        }
        return R;
    }
}