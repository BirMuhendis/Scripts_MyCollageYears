package MyStack;

public class Node<E> {
    E data;
    Node<E> next;

    Node (E data)
    {
        this.data=data;
        this.next=null;
    }
    public E getData()
    {
        return data;
    }
    public Node<E> getNext()
    {
        return next;
    }
}
