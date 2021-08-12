package com.mytechexp.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*
            1
          /     \
         2       3
        /  \    /  \
       4    5  6    7
                \  /  \
                 8 10  9 
                     \
                     11
                       \
                        12  
                        
    Output->[4],[2],[1,5,6],[3,8,10],[7,11],[9,12]
*/
public class VerticalOrderVariation {

    class QueNode
    {
        int horizontalDistance;
        TreeNode node;
        public QueNode(int hd,TreeNode node)
        {
            this.horizontalDistance=hd;
            this.node=node;
        }


    }

    public static void main(String[] arg)
    {  
        VerticalOrderVariation verticalOrderVariation=new VerticalOrderVariation(); 
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);
        verticalOrderVariation.VerticalOrderDryrun(root);

    }

    private void VerticalOrderDryrun(TreeNode root) {

        if(root==null)
         return;

        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        Queue<QueNode> queue=new LinkedList<>();
        queue.add(new QueNode(0, root));
        while(!queue.isEmpty())
        {
         QueNode temp=queue.poll();
         int hd=temp.horizontalDistance;
         TreeNode node=temp.node;
         map.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(node.data);
        
         if(node.left!=null)
            queue.add(new QueNode(hd-1, node.left));
        if(node.right!=null)
            queue.add(new QueNode(hd+1, node.right));


        }
        for(ArrayList<Integer> val:map.values())
        {
            System.out.println(val);
        }

    }
    
}
