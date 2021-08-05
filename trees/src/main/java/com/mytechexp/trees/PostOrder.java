package com.mytechexp.trees;

public class PostOrder {
    TreeNode root;

    void postOrder(TreeNode root)
    {
        if(null==root)
         return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d->",root.data);
    }
    
}
