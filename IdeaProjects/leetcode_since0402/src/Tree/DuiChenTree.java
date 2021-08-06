package Tree;

import CommonClassUtils.TreeNode;

public class DuiChenTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return  recur(root.left,root.right);

    }

    boolean recur(TreeNode left, TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;
        return recur(left.left,right.right)&&recur(left.right,right.left);


    }
}
