

/* you have to just imagine that you got left substree val and right subtree value now you want a maximum path so you have three condition condition number no you took left+right+root.val condition no 2 you took only one value max(l,r)+root.val condition no 3 you took only root value now ig you want to take maximum you can take maximum of three condotion but inorder to return the value you can return max(1condition ans second condition) */
    class Solution {
    int maxsum=Integer.MIN_VALUE;
    int solve(TreeNode root){
        if(root==null) return 0;
        int l=solve(root.left);
        int r=solve(root.right);
        int ek_hi_accha_hai=Math.max(l,r)+root.val;
        int root_hi_accha_hai=root.val;
        int dono_aacha_hai=l+r+root.val;
        maxsum=Math.max(maxsum,Math.max(ek_hi_accha_hai,Math.max(root_hi_accha_hai,dono_aacha_hai)));
        return Math.max(root_hi_accha_hai,ek_hi_accha_hai);
    }
    public int maxPathSum(TreeNode root) {
        maxsum=Integer.MIN_VALUE;
         solve(root);
         return maxsum;
    }
}

