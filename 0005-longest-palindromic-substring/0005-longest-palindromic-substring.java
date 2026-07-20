class Solution {
    static Boolean[][] memo; // Boolean (capital B) so we can use null to mean "not computed yet"

    static boolean solve(String s, int i, int j) {
        if (i >= j) return true;

        if (memo[i][j] != null) return memo[i][j]; // already computed — reuse it

        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = solve(s, i + 1, j - 1);
        }

        return memo[i][j] = false; // <- the line that was missing/unclear in your screenshot
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n]; // defaults to null in Java — perfect as "not computed" marker

        int Max = -1;
        int si = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j)) {          // check directly against s, using i and j — no substring needed anymore!
                    if (Max < j - i + 1) {
                        Max = j - i + 1;
                        si = i;
                    }
                }
            }
        }
        return s.substring(si, si + Max);
    }
}