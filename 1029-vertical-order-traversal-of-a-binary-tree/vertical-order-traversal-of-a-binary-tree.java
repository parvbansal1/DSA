class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(root, 0, 0, list);

        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1]; 
            return a[2] - b[2];                     
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] a : list) {
            if (a[0] != prevCol) {
                res.add(new ArrayList<>());
                prevCol = a[0];
            }
            res.get(res.size() - 1).add(a[2]);
        }
        return res;
    }

    void dfs(TreeNode root, int col, int row, List<int[]> list) {
        if (root == null) return;
        list.add(new int[]{col, row, root.val});
        dfs(root.left, col - 1, row + 1, list);
        dfs(root.right, col + 1, row + 1, list);
    }
}
