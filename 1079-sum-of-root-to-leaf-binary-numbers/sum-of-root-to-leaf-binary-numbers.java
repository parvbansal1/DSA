class Solution {
    StringBuilder s = new StringBuilder();

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        ArrayList<String> ans = new ArrayList<>();
        find(root, ans);
        int sum = 0;
        for (String a : ans) {
            sum += Integer.parseInt(a, 2);
        }
        return sum;
    }

    public void find(TreeNode root, ArrayList<String> sum) {
        if (root == null)
            return;
        s.append(root.val);
        if (root.left == null && root.right == null) {
            String str = s.toString();
            sum.add(str);
        } else {
            find(root.left, sum);
            find(root.right, sum);
        }
        s.deleteCharAt(s.length() - 1);
    }
}