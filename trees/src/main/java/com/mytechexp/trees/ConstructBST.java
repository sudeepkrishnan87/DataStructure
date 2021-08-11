package com.mytechexp.trees;

public class ConstructBST {
    TreeNode node;
    public TreeNode sortedArrayToBST(final int[] A) {
        
         node= createBST(A,0,A.length-1);
  
        return node;
    }
  public TreeNode createBST(int[] arr,int start,int end)
  {
      if(start>end)
      return null;
    int mid=start+(end-start)/2;
    
    TreeNode node=new TreeNode(arr[mid]);
    node.left=createBST( arr, start, mid-1);
    node.right=createBST( arr, mid+1, end);
    return node;
  }
}
