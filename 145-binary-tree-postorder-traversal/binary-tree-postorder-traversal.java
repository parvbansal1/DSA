class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        post(root,ans);
        return ans;
    }
    public void post(TreeNode root, List<Integer> ans){
        if(root==null) return ;
        post(root.left,ans);
        post(root.right,ans);
        ans.add(root.val);
    }
}