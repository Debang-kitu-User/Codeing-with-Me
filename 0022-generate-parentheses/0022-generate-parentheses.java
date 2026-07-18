class Solution {
    List<String> result = new ArrayList<>();

    public static boolean isValid(String current) {
        int count = 0;
        for (char ch : current.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public void parenthesis(StringBuilder current, int n) {
        if (current.length() == 2 * n) {
            if (isValid(current.toString()))
                result.add(current.toString());
            return;
        }
        current.append('(');
        parenthesis(current, n);
        current.deleteCharAt(current.length() - 1);

        current.append(')');
        parenthesis(current, n);
        current.deleteCharAt(current.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        parenthesis(new StringBuilder(), n);
        return result;
    }
}