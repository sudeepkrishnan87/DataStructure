package com.mytechexp.trees;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {
TreeNode root;
public void inorder()
{

 
/*    1
    /   \
  2      3
/  \
4     5
out put for in order is left,root,right

4,2,5,1,3
*/

    TreeNode curnode=root;
    Stack <TreeNode> st=new Stack<>();
    ArrayList<Integer> result=new ArrayList<>();
    while(curnode!=null|| !(st.empty()))
    {
       while(curnode!=null)
       {
           st.push(curnode);
           curnode=curnode.left;
           //scope to get the left height of the tree also 
       }
       curnode=st.pop();
       System.out.println(curnode.data);
       curnode=curnode.right;
    }
}
void inorder_rec(TreeNode node)
{
    if(null==node)
    {
        return;
    }
  
    inorder_rec(node.left);
    System.out.print(node.data+" ");
    inorder_rec(node.right);
}

}
