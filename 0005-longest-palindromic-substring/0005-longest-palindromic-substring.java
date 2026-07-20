class Solution {
    static boolean solve(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return solve(s, i + 1, j - 1);
        }
        return false;
    }

    public String longestPalindrome(String s) {
        int Max = -1;
        int si = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (solve(sub, 0, sub.length() - 1)) {
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