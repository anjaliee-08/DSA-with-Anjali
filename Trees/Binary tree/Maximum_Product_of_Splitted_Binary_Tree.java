 /* Imagine we have an array where we put element of this binary tree that is [1,2,3,4,5,6] now consider that you split from 1 and remaining sum of the array you will find and take the product and store it in the maxproduct same you have to in tree that you have to consider a node find the summiation of its subtree then substract from the compelte sum and update the maxprod by taking product of this twoo s1 na d s2 terms  */
class Solution {
    long SUM=0;
    long maxProduct=0;
    long mod=1_000_000_007;
    int totalsum(TreeNode root){
        if(root==null) return 0;
        return root.val+totalsum(root.left)+totalsum(root.right);
    }
    long maxProd(TreeNode root){
        if(root==null) return 0;
        long s1=root.val+maxProd(root.left)+maxProd(root.right);
        long s2=SUM-s1;
        maxProduct=Math.max(maxProduct,s1*s2);
        return s1;
    }
    public int maxProduct(TreeNode root) {
        if(root==null) return 0;
        SUM=totalsum(root);
        maxProd(root);
        return (int)(maxProduct%mod);
    }
}