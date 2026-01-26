class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        find(ans, n, n, "");
        return ans;
    }

    public void find(List<String> arr, int open, int close, String s) {
        if (open == 0 && close == 0) {
            arr.add(s.toString());
            return;
        }
        if (open > 0)
            find(arr, open - 1, close, s + "(");
        if (close > open)
            find(arr, open, close - 1, s + ")");
    }
}