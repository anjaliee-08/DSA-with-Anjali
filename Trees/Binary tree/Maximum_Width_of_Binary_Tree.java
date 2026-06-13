

class Solution {
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        int maxdiff=0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
           
            int first=q.peek().idx;
            int last=first;
            for(int i=0;i<size;i++){
            Pair p=q.poll();
           TreeNode node=p.node;
           int curridx=p.idx;
           last=curridx;
            if(node.left!=null){
                q.offer(new Pair(node.left,2*curridx+1));
            }if(node.right!=null){
                q.offer(new Pair(node.right,2*curridx+2));
            }
            }
            maxdiff=Math.max(maxdiff,last-first+1);
        }
        return maxdiff;
    }
}
