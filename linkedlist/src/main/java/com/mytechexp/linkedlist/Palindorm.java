package com.mytechexp.linkedlist;

import java.util.LinkedList;

public class Palindorm {
    Node node;
    public boolean checkPalindeom(Node node)
    {
        
        Node slow=node,fast=node,slowprev=node;
        Node midNode=null,secondHalf;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slowprev=slow;
            slow=slow.next;  
        }

        if(fast!=null)
        {
            midNode=slow;
            slow=slow.next;

        }

        secondHalf=slow;
        slowprev.next=null;
        secondHalf=reverse(secondHalf);
        boolean result=compareList(node,secondHalf);
        return result;

    }

    private boolean compareList(Node node2, Node secondHalf) {
        while(node!=null && secondHalf!=null)
         {
             if(!(node.data==secondHalf.data))
              return false;
              else{
                  node=node.next;
                  secondHalf=secondHalf.next;
              }
         }

        return true;
    }

    private Node reverse(Node secondHalf) {
      Node curr=secondHalf,prev=null,next;
        while(curr!=null)
        {
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
        }
        return prev;
    }


    public static void main(String arg[])
    {
        Palindorm pal=new Palindorm();
       Node node=new Node(1);
       Node node1=new Node(2);
       Node node2=new Node(2);
       Node node3=new Node(1);
       node.next=node1;
       node1.next=node2;
       node2.next=node3;
       node3.next=null;
       System.out.println(pal.checkPalindeom(node));
       
       
        pal.checkPalindeom(node);
    }
    
}
