import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class Solution {
    int sumPath(TreeNode root,ArrayList<Integer> ans,int num){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            num=num*10+root.val;
            ans.add(num);
            return num%10;
        }
        num=num*10+root.val;
        sumPath(root.left,ans,num);
        sumPath(root.right,ans,num);
        return num;
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        int num=0;
        sumPath(root,ans,num);
        int sum=0;
        for(int a:ans){
        sum+=a;
        }
        return sum;
    }
} {
    
}
