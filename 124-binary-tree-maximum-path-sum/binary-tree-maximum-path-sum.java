class Solution {
    int maxLen = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int a = Math.max(0, dfs(root.left));
        int b = Math.max(0, dfs(root.right));
        maxLen = Math.max(maxLen, a + b + root.val);
        return root.val + Math.max(a, b);
    }
}
