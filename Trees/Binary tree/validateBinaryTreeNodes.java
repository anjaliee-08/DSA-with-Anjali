class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,Integer> childtoparent=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            int node=i;
            int leftc=leftChild[i];
            int rightc=rightChild[i];
            if(leftc!=-1){
                adj.putIfAbsent(node,new ArrayList<>() );
                adj.get(node).add(leftc);
                if(childtoparent.containsKey(leftc)) return false;
                childtoparent.put(leftc,node);
            }
             if(rightc!=-1){
                adj.putIfAbsent(i,new ArrayList<>() );
                adj.get(node).add(rightc);
                if(childtoparent.containsKey(rightc)) return false;
                childtoparent.put(rightc,node);
            }
        }
        int root=-1;
        for(int i=0;i<n;i++){
            if(!childtoparent.containsKey(i)){
                if(root==-1){
                    root=i;
                }else return false;
            }
        }
        if(root==-1) return false;
        Queue<Integer> q=new LinkedList<>();
        boolean[] isvisted=new boolean[n];
        isvisted[root]=true;
        q.offer(root);
        int count=1;
        while(!q.isEmpty()){
           
            int node=q.poll();
        for(int child : adj.getOrDefault(node,new ArrayList<>())){
        if(isvisted[child]) return false;  
        isvisted[child] = true;
        count++;
        q.offer(child);
         }
        }
      return count==n;

    }
}
