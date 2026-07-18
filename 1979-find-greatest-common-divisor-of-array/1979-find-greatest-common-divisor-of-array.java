class Solution {
    public int findGCD(int[] nums) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int min = Integer.MAX_VALUE;
        for (int x : nums)
            min = Math.min(min, x);

        return GCD(max, min);
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}