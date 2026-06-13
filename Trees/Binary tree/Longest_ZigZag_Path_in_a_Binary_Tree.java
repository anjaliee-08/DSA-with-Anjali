class Solution {
    int max_path=Integer.MIN_VALUE;
    int find(TreeNode root,int steps,boolean isleft){
        if(root==null) return 0;
        max_path=Math.max(max_path,steps);
        if(isleft){
            find(root.left,steps+1,false);
            find(root.right,1,true);
        }else{
            find(root.right,steps+1,true);
            find(root.left,1,false);
        }
        return max_path;
    }
    public int longestZigZag(TreeNode root) {

     max_path=Integer.MIN_VALUE;
     return Math.max(find(root,0,true),find(root,0,false));  
    }
}
