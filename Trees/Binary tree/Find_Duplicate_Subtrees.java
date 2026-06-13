class Solution {
    String getSubTree(TreeNode root,HashMap<String,Integer> map,ArrayList<TreeNode> ans){
        if(root==null) return "N";
        String s=Integer.toString(root.val)+","+getSubTree(root.left,map,ans)+","+getSubTree(root.right,map,ans);
        int cnt=map.getOrDefault(s,0);
        if(cnt==1) ans.add(root);
        map.put(s,map.getOrDefault(s,0)+1);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<TreeNode> ans=new ArrayList<>();
        getSubTree(root,map,ans);
        return ans;
    }
}
