class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int del = 0;

        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() == 'b' && s.charAt(i) == 'a') {
                st.pop();
                del++;
            } else
                st.push(s.charAt(i));
        }

        return del;
    }
}