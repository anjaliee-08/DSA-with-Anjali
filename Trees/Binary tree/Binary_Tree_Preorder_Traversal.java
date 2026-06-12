import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Binary_Tree_Preorder_Traversal {
    class Solution {
    void preorder(TreeNode root,List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
        return;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
}
}
