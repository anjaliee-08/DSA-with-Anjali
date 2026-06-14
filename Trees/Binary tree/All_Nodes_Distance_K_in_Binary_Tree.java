class Solution {
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    void inorder(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            map.put(root.left,root);
        }
        inorder(root.left);
        if(root.right!=null){
            map.put(root.right,root);
        }
        inorder(root.right);
        return;
    }
    void BFS(TreeNode target,int k,ArrayList<Integer> result){
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        q.offer(target);
        set.add(target.val);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            if(level==k) break;
            while(n>0){
             TreeNode node=q.poll();
             if(node.left!=null && !set.contains(node.left.val)){ 
                q.offer(node.left);
                set.add(node.left.val);
                }
             if(node.right!=null && !set.contains(node.right.val)) {
                q.offer(node.right);
                set.add(node.right.val);
                }
                TreeNode parent=map.get(node);
             if(parent!=null && !set.contains(parent.val)){
                q.offer(parent);
                set.add(parent.val);

             }
             n--;
            }
            level++;
        }
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       ArrayList<Integer> result=new ArrayList<>();
       inorder(root);
       BFS(target,k,result);
       return result; 
    }
}
