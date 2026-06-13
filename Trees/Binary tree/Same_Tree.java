class Solution {
    /*in here just remember in what cases the two tree will not be same  */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null && p==null) return true;
        if(q==null) return false;
        if(p==null) return false;
        if(q.val!=p.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}