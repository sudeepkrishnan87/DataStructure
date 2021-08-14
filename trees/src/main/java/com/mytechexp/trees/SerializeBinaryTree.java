package com.mytechexp.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
            1
          /   \
         2     3
        / \     \
       4   5     6

       o/p

[1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
*/
public class SerializeBinaryTree {

    class QNod
    {
        int data;
        TreeNode node;
        QNod(TreeNode node)
        {
            this.data=node.data;
            this.node=node;
        }
        QNod(int data)
        {
            this.data=data;
            this.node=null;
        }
    }
    public static void main(String arg[])
    {
        SerializeBinaryTree seriealizeObj=new SerializeBinaryTree();
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.right=new TreeNode(6);
        seriealizeObj.serializeTree(node);
    }

    public void serializeTree(TreeNode root)
    {
        List<Integer> result=new ArrayList<>();
        Queue<QNod> q=new LinkedList<>();
        QNod node=new QNod(root);
        q.add(node);
        QNod temp=null;
        TreeNode tempNode=null;
        while(!q.isEmpty())
        {
         temp=q.poll();
         tempNode=temp.node;
         result.add(temp.data);
      
         if(null!=tempNode && tempNode.left!=null)
          q.add(new QNod(tempNode.left));
        else if(tempNode!=null && tempNode.left==null)
          q.add(new QNod(-1)); 
         if(null!=tempNode && tempNode.right!=null)
          q.add(new QNod(tempNode.right));
          else if(tempNode!=null && tempNode.right==null)
          q.add(new QNod(-1));

        }
        result.forEach(i->System.out.print(i+" "));

    }
    
}
