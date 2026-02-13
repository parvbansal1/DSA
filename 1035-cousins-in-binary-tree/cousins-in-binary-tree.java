class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int l1 = -1, l2 = -1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode temp = q.remove();
                if(temp.val == x) l1 = level;
                if(temp.val == y) l2 = level;
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            level++;
            if(l1 != l2) return false;
            if(l1 != -1) break;
        }
        return !parent(root, x, y);
    }
    public boolean parent(TreeNode root, int x, int y){
        if(root==null) return false;
        if(root.left!=null && root.right!=null){
            if(root.left.val == x && root.right.val == y) return true;
            if(root.left.val == y && root.right.val == x) return true;
        }
        return parent(root.left,x,y) || parent(root.right,x,y);
    }
}