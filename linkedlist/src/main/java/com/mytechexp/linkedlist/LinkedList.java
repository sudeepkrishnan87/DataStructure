package com.mytechexp.linkedlist;
public class LinkedList {
    Node head;
  //Inserts at the end  
public void add(int data)
{
    Node node=new Node(data);
    if(null==head)
    {
      head=node;
    }
    else
    {
        Node itrNode=head;
        while(null!=itrNode.next)
        {
          itrNode=itrNode.next;
        }
        itrNode.next=node;
    }
}
//insert at front
public void insertFront(int data)
{
    Node node=new Node(data);
    if(null==head)
    {
        head=node;
    }
    else{
        node.next=head;
        head=node;
    }
}
  
//insert at Specific Position
public void insertAt(int index,int data)
{
    if(null==head)
     return;
     Node node=new Node(data);
     Node itrNode=head;
    int counter=1;
    while(counter<index-1)
    {
        itrNode= itrNode.next;
        counter++;
    }
    Node next=itrNode.next;
    itrNode.next=node;
    node.next=next;

}
//show the list
public void showList()
{
    Node itrNode=head;
    System.out.println();
    while(null!=itrNode.next)
    {
        System.out.print(itrNode.data+" ");
        itrNode=itrNode.next;
    }
    System.out.print(itrNode.data);
}


/*
reverse list with bucket size

 A = [1, 2, 3, 4, 5, 6]
 B = 2
 [2, 1, 4, 3, 6, 5]
*/

public Node reverseList(int B)
{
    head=reverseList(head, B) ;
    return head;
}
public Node reverseList(Node A, int B) {
    if(A==null || B==1)
     return A;
    
     Node current=A;
     Node next=null;
     Node prev=null;
    
    int counter=0;
    while(counter<B && current!=null)
    {
        next=current.next;
        current.next=prev;
        prev=current;
        current=next;
        counter++;
    }
    if(next!=null)
      A.next =reverseList(next,B);
      
  return prev;
    
}

/*
special code to rearrange the list in special order
Given list A: A0 → A1 → … → An-1 → An 
 A0 → An → A1 → An-1 → A2 → An-2 → 

  A = [1, 2, 3, 4, 5] 
   [1, 5, 2, 4, 3] 
*/

public void specialOrder()
{
    
    Node itrNode=head;
    int length=1;
    while(itrNode.next!=null)
    {
    length++;
    itrNode=itrNode.next;
    }
   
    if(length==1|| length==2)
     return ;
    
    Node firstBucket=head;
    //to seperate two buckets
    int mid= length/2;
    for(int i=0;i<mid-1;i++)
     firstBucket=firstBucket.next;

     //break the firstBucket
     Node secondStart=firstBucket.next;
     firstBucket.next=null;


    
    
    
    Node secondBucket=reverseNode(secondStart,length-mid);
    
    joinSpecial(head,secondBucket,mid);
    
}

private Node reverseNode(Node second, int index) {
    Node curr=second,next=null,prev=null;
    while(curr!=null)
    {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
   
}
private void joinSpecial(Node firstBucket, Node secondBucket,int mid) {
//5 3 2 1
//5 1 3 2


  Node temp=new Node(0);
  head=temp;
  while(firstBucket!=null || secondBucket!=null)
  {
      if(firstBucket!=null)
      {
        temp.next=firstBucket;
        firstBucket=firstBucket.next;
        temp=temp.next;
      }
      if(secondBucket!=null)
      {
          temp.next=secondBucket;
          secondBucket=secondBucket.next;
          temp=temp.next;
      }
  }
  
  head=head.next;
   

   }
   

}

