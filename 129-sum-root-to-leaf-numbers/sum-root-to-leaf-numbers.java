class Solution {
    StringBuilder s = new StringBuilder();

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<String> arr = new ArrayList<>();
        dfs(root, arr);
        int sum = 0;
        for (String str : arr) {
            sum += Integer.parseInt(str);
        }
        return sum;

    }

    public void dfs(TreeNode root, ArrayList<String> arr) {
        if (root == null)
            return;
        s.append(root.val);
        if (root.left == null && root.right == null) {
            arr.add(s.toString());
        } else {
            dfs(root.left, arr);
            dfs(root.right, arr);
        }
        s.deleteCharAt(s.length() - 1);
    }
}