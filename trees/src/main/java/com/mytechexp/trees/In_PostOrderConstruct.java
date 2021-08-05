package com.mytechexp.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Given inorder and postorder traversal of a tree, construct the binary tree.

First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]



   1  
  / \
 6   2
    /
   3

*/
public class In_PostOrderConstruct {
    TreeNode root;
    int postIndex=0;
    Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    void constructTree(ArrayList<Integer> in, ArrayList<Integer> post,int length) {
        
        for(int i=0;i<length;i++)
        map.put(in.get(i), i);
        postIndex=length-1;
        TreeNode curNode=buildTree(in,post,0,length-1);
        System.out.println();
        preOrder(curNode);

    }
     void preOrder(TreeNode node)
{
    if (node == null)
        return;
    System.out.printf("%d ",node.data);
    preOrder(node.left);
    preOrder(node.right);
}
    private TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post, int start, int end) {

        if(start>end)
         return null;

        int cur=post.get(postIndex);
        TreeNode node=new TreeNode(cur);
        postIndex--;

        if(start==end)
          return node;

          int iIndex=map.get(cur);
          node.right=buildTree(in,post,iIndex+1,end);
          node.left=buildTree(in,post,start,iIndex-1);

        return node;
    }

}
