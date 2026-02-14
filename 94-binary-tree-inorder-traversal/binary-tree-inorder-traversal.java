class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st = new Stack<>();
        Stack<Boolean> vis = new Stack<>();
        vis.push(false);
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            boolean flag = vis.pop();
            if(!flag){
                if(temp.right!=null){
                    st.push(temp.right);
                    vis.push(false);
                }
                st.push(temp);
                vis.push(true);
                if(temp.left!=null){
                    st.push(temp.left);
                    vis.push(false);
                }
            }
            else{
                ans.add(temp.val);
            }
            
        }
        return ans;
    }
}