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
/*
public class Solution {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> ans=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> solve(int A) {
        //A=3
     int previous=0;
     //Complexity=O(n^2)
     for(int i=1;i<=A;i++)//1--3
     {
        for(int j=A;j>=1;j--)//3--1 
        {
            if(i==j)// i=3    3  2  1  previous=1
            {
             ans.add(j); 
             previous=j;
            }
            else if(j<i)
            {
              ans.add(--previous);  
            }
            else
            {
             ans.add(0);        
             previous=0;
            }
        }
        result.add(ans);
        ans=new ArrayList<>();
     }
     return result;
        
    }
}
*/