package com.mytechexp.trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

       Inorder tree = new Inorder();
        
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.inorder();
        tree.inorder_rec(tree.root);

        In_PostOrderConstruct inpost=new In_PostOrderConstruct();
        // tree.root=new TreeNode(1);
        // tree.root.left=new TreeNode(2);
        // tree.root.right = new TreeNode(3);
        // tree.root.left.right=new TreeNode(5);
        // tree.root.left.left=new TreeNode(4);
        // tree.root.left.left.left=new TreeNode(7);
        // tree.root.left.left.right=new TreeNode(9);
        // tree.root.right.right = new TreeNode(6);
        // tree.root.right.right = new TreeNode(8);


        Integer[] A=new Integer[]{6,1,3,2};
        Integer[] B=new Integer[]{6,3,2,1};
       ArrayList<Integer> inorder=new ArrayList<>(Arrays.asList(A));
       ArrayList<Integer> postOrder=new ArrayList<>(Arrays.asList(B));

       inpost.constructTree(inorder, postOrder, inorder.size());  
       
       System.out.println();
       Preorder pre=new Preorder();
       pre.node = new TreeNode(1);
       pre.node.left = new TreeNode(12);
       pre.node.right = new TreeNode(9);
       pre.node.left.left = new TreeNode(5);
       pre.node.left.right = new TreeNode(6);
       pre.preorder(pre.node);

       Preorder pre_iter=new Preorder();
       pre_iter.node = new TreeNode(1);
       pre_iter.node.left = new TreeNode(12);
       pre_iter.node.right = new TreeNode(9);
       pre_iter.node.left.left = new TreeNode(5);
       pre_iter.node.left.right = new TreeNode(6);
       pre_iter.preorder_Iterative(pre_iter.node);
      
       System.out.println();
       PostOrder post=new PostOrder();
       post.root = new TreeNode(1);
       post.root.left = new TreeNode(12);
       post.root.right = new TreeNode(9);
       post.root.left.left = new TreeNode(5);
       post.root.left.right = new TreeNode(6);
       post.postOrder(post.root);


       int[] arr=new int[]{1, 2, 3};
       System.out.println("BST");
       ConstructBST bst=new ConstructBST();
       TreeNode node= bst.sortedArrayToBST(arr);

    }
}
