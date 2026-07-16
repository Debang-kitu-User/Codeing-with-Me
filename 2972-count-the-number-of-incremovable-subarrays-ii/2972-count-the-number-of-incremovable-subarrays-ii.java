class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;

        // Find the last index of the longest strictly increasing prefix
        int i = 0;
        while (i + 1 < n && nums[i] < nums[i + 1])
            i++;

        // Special case: the whole array is already strictly increasing.
        // Removing ANY subarray leaves a valid strictly increasing remainder.
        if (i == n - 1)
            return (long) n * (n + 1) / 2;

        // Case A: keep only the prefix nums[0..i], remove everything after it.
        // That's (i+2) ways: remove nums[i+1..n-1], or nums[i..n-1], ..., or nums[0..n-1] down to keeping just index 0? 
        // (Concretely: i+2 = number of valid "cut points" at/after i+1 through end, plus removing the whole array from 0)
        long ans = i + 2;

        // Case B: keep a strictly increasing suffix starting at j, and shrink the kept prefix (pointer i)
        // so that nums[i] < nums[j] still holds.
        for (int j = n - 1; j > 0; j--) {
            while (i >= 0 && nums[i] >= nums[j])
                i--;
            ans += i + 2;
            // Stop once the suffix itself is no longer strictly increasing going backward
            if (nums[j - 1] >= nums[j])
                break;
        }

        return ans;
    }
}