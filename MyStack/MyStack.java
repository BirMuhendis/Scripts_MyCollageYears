package MyStack;
public class MyStack<E> {
    Node<E> top = null;

    public void push(E data)
    {
        Node<E> newNode = new Node<E>(data);
        newNode.next=top;
        top=newNode;
    }
    public E pop()
    {
        Node<E> oldTopNode = peek();
        top=top.next;
        return (E) oldTopNode;
    }
    public void PrintStack()
    {
        if (top==null) 
        {
            System.out.println("Empty");    
        }
        else
        {
            Node<E> temp = top;
            while (temp!=null) 
            {
                System.out.println("|"+temp.data + "|");
                temp=temp.next;
            }
            System.out.println("---");
        }
    }
    public boolean isEmpty()
    {
        return (top==null);
    }
    public Node<E> peek()
    {
        return top;
    }
    public void clearStack()
    {
        top=null;
    }
    public int size()
    {
        int counter=0;
        Node<E> temp = top;
        while (temp!=null) 
        {
            counter++;
            temp=temp.next;    
        }
        return counter;
    }
}
