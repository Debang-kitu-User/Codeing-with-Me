class Solution {
    List<String> result = new ArrayList<>();
    public void parenthesis(StringBuilder current, int n, int open, int close) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        if(open < n) {
            current.append('(');
            parenthesis(current, n, open+1, close);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < open) {
            current.append(')');
            parenthesis(current, n, open, close+1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        int open =0;
        int close =0;

        parenthesis(new StringBuilder(), n, open, close);
        return result;
    }
}