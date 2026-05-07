class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int[] curr = {nums[i], i, i};
            while (!st.isEmpty() && st.peek()[0] > nums[i]) {
                int[] top = st.pop();
                curr[0] = Math.max(curr[0], top[0]);
                curr[1] = top[1];
            }

            st.push(curr);
        }

        while (!st.isEmpty()) {
            int[] p = st.remove(0);
            for (int i = p[1]; i <= p[2]; i++) {
                ans[i] = p[0];
            }
        }

        return ans;
    }
}