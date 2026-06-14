
    
class Solution {
    int res=0;
    void solve(TreeNode root,int[] freq){
        if(root==null) return;
        freq[root.val]++;
        if(root.left==null && root.right==null){
            int oddfreq=0;
            for(int i=1;i<10;i++){
                if(freq[i]%2!=0) oddfreq++;
            }
           if(oddfreq<=1) res+=1;
        }
           solve(root.left,freq);
          solve(root.right,freq);
          freq[root.val]--;
           return;
        

    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq=new int[10];
        solve(root,freq);
        return res;
    }
}
