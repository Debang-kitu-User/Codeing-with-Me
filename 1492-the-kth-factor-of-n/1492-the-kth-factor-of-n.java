class Solution {
    public int kthFactor(int n, int k) {
        int count = 1;
        for (int fact = 1; fact <= n; fact++) {

            if (n % fact == 0) {

                if (count == k) {
                    return fact;
                }
                count++;
            }
        }
        return -1;
    }
}