class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return build(inorder, 0, inorder.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode build(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = build(list, start, mid - 1);
        node.right = build(list, mid + 1, end);

        return node;
    }
}