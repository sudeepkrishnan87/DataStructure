package com.mytechexp.trees;

public class Preorder {
    TreeNode node;

    void preorder(TreeNode root)
    {
       if(root==null)
        return;

       System.out.printf("%d->",root.data);
       preorder(root.left);
       preorder(root.right);
   
    }   
}
