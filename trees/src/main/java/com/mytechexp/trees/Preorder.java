package com.mytechexp.trees;
import java.util.Stack;
public class Preorder {
    TreeNode node;
    Stack<TreeNode> stack=new Stack<>();

    void preorder(TreeNode root)
    {
       if(root==null)
        return;

       System.out.printf("%d->",root.data);
       preorder(root.left);
       preorder(root.right);
   
    }   
    void preorder_Iterative(TreeNode A)
    {
       System.out.println();
       stack.push(A);
       System.out.println("Pre-Iterative way");
        while(!stack.empty())
        {
         A=stack.pop();
         System.out.printf("%d->",A.data);
        if(A.right!=null)
        stack.push(A.right);
        if(A.left!=null)
        stack.push(A.left);
        }
    }
}
