package com.mytechexp.linkedlist;

public class LongestPalindrom {

    
    public static void main(String []arg)
    {
        //Preparing the Input   
        Node node=new Node(2);
        node.next=new Node(3);
        node.next.next=new Node(3);
        node.next.next.next=new Node(3);

        LongestPalindrom lpal=new LongestPalindrom();
        System.out.println(lpal.longestPalindrom(node));

        //Should retuen 3
    }

    private int longestPalindrom(Node node) {
      int result=0;
      
      if(node==null)
       return result;

       result=1;//minumum 1 guarenteed
       if(node.next==null)
        return result;
       Node next=null,prev=null;
      while(node!=null)
      {
          next=node.next;
          node.next=prev;

          result=Math.max(result, 2*getElementCount(prev,next)+1);
          result=Math.max(result, 2*getElementCount(node,next));

          prev=node;
          node=next;

      }
        

      return result;
    }

    private int getElementCount(Node node, Node rightNode) {
        int counter=0;
        while(node!=null && rightNode!=null)
        { 
            if(node.data!=rightNode.data)
            return counter;
            node=node.next;
            rightNode=rightNode.next;
            counter++;

        }
        return counter;
    }

    
    
}
