

    
class Solution {
    public TreeNode createBinaryTree(int[][] des) {
        int n=des.length;
        HashMap<Integer,TreeNode> map=new HashMap<>();
        HashSet<TreeNode> childe=new HashSet<>();
        for(int i=0;i<n;i++){
            int parent=des[i][0];
            int child=des[i][1];
            int isleft=des[i][2];
            if(!map.containsKey(parent)){
                map.put(parent,new TreeNode(parent));
            }
            if(!map.containsKey(child)){
                map.put(child,new TreeNode(child));
            }
            if(isleft==0){
                map.get(parent).right=map.get(child); 
            }    
            if(isleft==1){
                map.get(parent).left=map.get(child); 
            }
            childe.add(map.get(child));
        }
        for(int i=0;i<n;i++){
            if(!childe.contains(map.get(des[i][0]))) return map.get(des[i][0]);
        }
        return (new TreeNode(0));
    }
}
