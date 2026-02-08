class Solution {
    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == -1 || rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (height(root) == -1)
            return false;
        return true;
    }
}