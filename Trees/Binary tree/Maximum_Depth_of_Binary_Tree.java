class Solution {
    int maxno=0;
    int dfs(TreeNode root,int idx){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
        maxno=Math.max(maxno,idx);
        return maxno;
        }
        dfs(root.left,idx+1);
        dfs(root.right,idx+1);
        return maxno;
    }
    public int maxDepth(TreeNode root) {
        maxno=0;
        return dfs(root,1);
    }
}
