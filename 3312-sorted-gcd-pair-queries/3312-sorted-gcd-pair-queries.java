class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        int[] cnt = new int[maxVal + 1];
        for (int x : nums) cnt[x]++;

        // freq[d] = how many numbers in nums are divisible by d
        int[] freq = new int[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                freq[d] += cnt[multiple];
            }
        }

        // exact[d] = number of pairs whose gcd is EXACTLY d
        long[] exact = new long[maxVal + 1];
        for (int d = maxVal; d >= 1; d--) {
            long pairsWithBothDivisibleByD = (long) freq[d] * (freq[d] - 1) / 2;
            long total = pairsWithBothDivisibleByD;
            for (int multiple = 2 * d; multiple <= maxVal; multiple += d) {
                total -= exact[multiple]; // remove pairs whose gcd is a larger multiple of d
            }
            exact[d] = total;
        }

        // prefix[d] = number of pairs with gcd <= d
        long[] prefix = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            prefix[d] = prefix[d - 1] + exact[d];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i]; // 0-indexed rank in the sorted gcdPairs array
            int lo = 1, hi = maxVal;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] > q) hi = mid;
                else lo = mid + 1;
            }
            answer[i] = lo;
        }
        return answer;
    }
}