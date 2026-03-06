class Solution {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null || temp.right != null) {
            if (height(temp.left) >= height(temp.right)) {
                temp = temp.left;
            } else
                temp = temp.right;
        }
        return temp.val;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);
        return Math.max(left, right);
    }
}