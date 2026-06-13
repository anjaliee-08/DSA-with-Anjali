class Solution {
    int idx=0;
    TreeNode solve(int[] postorder,int[] inorder,int start,int end){
        if(start>end) return null;
        int val=postorder[idx];
        idx--;
        int i=start;
        for(;i<=end;i++){
            if(inorder[i]==val) break;
        }
        TreeNode root=new TreeNode(val);
        root.right=solve(postorder,inorder,i+1,end);
        root.left=solve(postorder,inorder,start,i-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        idx=n-1;
        return solve(postorder,inorder,0,n-1);
    }
}
