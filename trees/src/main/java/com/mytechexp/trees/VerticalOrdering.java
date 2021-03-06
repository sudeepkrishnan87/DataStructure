package com.mytechexp.trees;

import java.util.ArrayList;
import java.util.TreeMap;

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

  

    TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
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
        
        
      ArrayList<ArrayList<Integer>> result=  vertObj.verticalOrder(root);
      result.forEach(i->System.out.println(i));
    }
    
}
