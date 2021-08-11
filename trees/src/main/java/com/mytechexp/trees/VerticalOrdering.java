package com.mytechexp.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

          1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
4
2
1 5 6
3 8
7
9


*/
public class VerticalOrdering {

  

    Map<Integer,ArrayList<Integer>> map=new HashMap<>();
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    int min=0,max=0;
ArrayList<ArrayList<Integer>> verticalOrder(TreeNode node)
{
    if(node==null)
      return result;

  findHorizontalDistance(node,min,max,0);

  for (ArrayList<Integer> list : map.values()) {
    result.add(list);
}

return result;

}

    private void findHorizontalDistance(TreeNode node, int min,int max,int hd) {

        if(node==null)
         return;
         if(hd<min)
         {
             min=hd;
         }
         if(hd>max)
         {
             max=hd;
         }
         map.computeIfAbsent(hd, k -> new ArrayList<Integer>()).add(node.data);
         
         findHorizontalDistance(node.left, min,max,hd-1);
         findHorizontalDistance(node.right,min,max,hd+1);
    }

    public static void main(String[] arg)
    {
        VerticalOrdering vertObj=new VerticalOrdering();
        TreeNode tree=new TreeNode(6);
        TreeNode head=tree;
        tree.left=new TreeNode(3);
        tree.right=new TreeNode(7);
        tree.left.left=new TreeNode(2);
        tree.left.right = new TreeNode(5);
       
        tree.right.right = new TreeNode(9);
        
        
      ArrayList<ArrayList<Integer>> result=  vertObj.verticalOrder(head);
      result.forEach(i->System.out.println(i));
    }
    
}
