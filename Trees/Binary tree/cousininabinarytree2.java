
    class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<Integer> levelsum=new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            int currsum=0;
            while(n>0){
                TreeNode node=q.poll();
                currsum+=node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
                n--;
            }
            levelsum.add(currsum);
        }
        int i=1;
        q.offer(root);
        root.val=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                TreeNode node=q.poll();
                int cousinsum=node.left!=null?node.left.val:0;
                cousinsum+=node.right!=null?node.right.val:0;
                if(node.left!=null){
                    node.left.val=levelsum.get(i)-cousinsum;
                    q.offer(node.left);
                }
                if(node.right!=null){
                    node.right.val=levelsum.get(i)-cousinsum;
                    q.offer(node.right);
                }
                n--;
            }
            i++;
        }
        return root;
    }
}
