package com.mytechexp.linkedlist;


public class LinkedListAddition {
Node headA=null,headB=null,result=null;

    public static void main(String []arg)
    {
       LinkedListAddition additionobj=new LinkedListAddition();
       
        Integer[] list1=new Integer[]{1,2,3};
        Integer[] list2=new Integer[]{2,3};
        
        for(int i=0;i<list1.length;i++)
        additionobj.push(list1[i],1);

        for(int i=0;i<list2.length;i++)
        additionobj.push(list2[i],2);
       Node result= additionobj.addList();
       result=additionobj.reverse(result);
       while(result!=null)
       {
       System.out.print(result.data);
       result=result.next;
       }
    }

private Node reverse(Node res) {

Node next=null,prev=null,cur=res;
while(cur!=null)
{
    next=cur.next;
    cur.next=prev;
    prev=cur;
    cur=next;
}

        return prev;
    }

private Node addList() {
    Node current=result;
    if(headA==null)
       return headB;
    else if(headB==null)
      return headA;
    else
    {
     
     int ans=0,carry=0;
     
    
         while(headA!=null && headB!=null)
         {
            
            ans= headA.data+headB.data+carry;
            carry=0;
            if(ans>=10)
            {
                
                carry=ans/10;
                ans=ans%10;
            }
             Node newNode=new Node(ans);
             if(current==null)
             {
                current=newNode;
                result=current;
             }
             
             else
             {
                current.next=newNode;
                current=current.next;
             }
             headA=headA.next;
             headB=headB.next;
         }
         while(headA!=null)
         {
            ans= headA.data+carry;
            if(ans>=10)
            {
                carry=ans/10;
                ans=ans%10;
                
            }
            Node newNode=new Node(ans);
            current.next=newNode;
            current=current.next;
            headA=headA.next;
            
         }
         while(headB!=null)
         {
            ans= headB.data+carry;
            if(ans>=10)
            {
                carry=ans/10;
                ans=ans%10;
                
            }
            Node newNode=new Node(ans);
            current.next=newNode;
            current=current.next;
            headB=headB.next;
         }

         if(carry!=0)
         {
             current.next=new Node(carry);
         }
         //result=current;
     }

    

    return result;
    }
    /*
push will do the reverse also 
*/
    private void push(Integer value,int flag) {

        Node node=new Node(value);
        if(flag==1)
        {
        node.next=headA;
        headA=node;
        }
        else if(flag==2)
        {
            node.next=headB;
            headB=node;
        }


    }
    
}
