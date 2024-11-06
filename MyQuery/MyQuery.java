package MyQuery;

import java.util.Queue;

public class MyQuery<E>
{
   Node<E> head;
   Node<E> tail;     

   public void printqueue()
   {
   if (head==null) 
   {
       System.out.println("Empty");    
   }
   else
   {
       Node<E> temp = head;
       while (temp!=null) 
       {
           System.out.println("|"+temp.data + "|");
           temp=temp.next;
       }
       System.out.println("---");
   }
}

   public void enqueue(E data)
   {
    Node<E> newNode = new Node<E>(data);
    if(head==null)
    {
        head=newNode;
        tail=newNode;
    }
    else
    {
        tail.next=newNode;
        tail=newNode;
    }
   }
   public Node<E> dequeue()
   {
    if(head==null)System.out.println("Empty Queue");
    else
    {
        head=head.next;
    }
    return head;
   }

   public Node<E> peek()
   {
    return head;
   }

   public static void main(String[] args) 
   {
    MyQuery<Integer> que = new MyQuery<Integer>();
    que.enqueue(1);
    que.enqueue(2);
    que.enqueue(3);
    que.enqueue(4);
    que.dequeue();
    que.printqueue();
    System.out.println(que.peek().getdata());
   }
}
