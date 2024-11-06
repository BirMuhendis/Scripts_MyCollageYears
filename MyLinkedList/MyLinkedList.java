package MyLinkedList;
public class MyLinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;

    public void Add(E data,int index)
    {
        Node<E> newNode = new Node<E>(data);
        Node<E> temp = head;
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            for(int i=0 ; i<index-1 ; i++)
            {
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    public void AddFirst(E data)
    {
        Node<E> newNode = new Node<E>(data);
        if(head==null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head=newNode;
        }
    }
    public void Add(E data)
    {
        Node<E> newNode = new Node<E>(data);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.next = newNode; 
            tail = newNode;
        }
    }
    public void Set(E data , int index)
    {
        Node<E> temp = head;
        Node<E> newNode = new Node<E>(data);
        if (index < 0) System.out.println("Index cannot be negative.");
        if (index==0)
        {
            newNode.next = temp;
            head = newNode;
            if (tail==null) tail = newNode;
            return;
        }
            for (int i=0; i<index-1 ; i++)
            {
                if(temp==null) System.out.println("Index exceeds list size!");
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        if (newNode.next==null) tail=newNode;
    }
    public int SizeList()
    {
        int counter=0;
        Node<E> temp = head;
        while(temp!=null)
        {
            counter++;
            temp=temp.next;
        }
        return counter;
    }
    public void PrintList()
    {
        Node<E> temp = head;
        if(head==null)  System.out.print("The list is empty!");
        else
        {
            System.out.print("\n Start -> ");
            while(temp != null)
            {
                System.out.print(temp.data + " -> ");
                temp=temp.next;
            }
            System.out.print("End\n");
        }
    }
    public void ClearList()
    {
        head=null;  tail=null;
    }
    public void RemoveLast()
    {
        Node<E> temp = head;
        while (temp.next.next!=null) {
            temp=temp.next;
        }
        temp.next=null;
        temp=tail;

        System.out.println("secili temp değeri :" + temp.data);
    }
    public void RemoveFirst()
    {
        head=head.next;
    }
    public void RemoveSpecific(E data)
    {
        Node<E> temp= head;
        while (temp!=null) 
        {
            if(temp.next.data==data)
            {
                temp.next=temp.next.next;
                return;
            }
            else
            {
                temp=temp.next;
            }    
        }
    }
    public Node<E> GetLast()
    {
        return tail;
    }
    public Node<E> GetFirst()
    {
        return head;
    }
    public Node<E> Get(int index)
    {
        Node<E> temp=null;
        if(index<0) 
        {
            System.out.println("This cannot be!");
        }
        else if(index>SizeList()) 
        {
            throw new NullPointerException ("This index exceeds of the list! @ Main:18");
        }
        else
        {
            temp=head;
            for(int i=0 ; i<index-1 ; i++)
            {
                temp=temp.next;
            }
        }
        
        return temp ;
    }
    public void RemoveToIndex(int index) 
    {
        if (index < 0 || index >= SizeList()) 
        {
            System.out.println("This index cannot be!");
            return;
        }
        
        if (index == 0) {
            RemoveFirst();
            return;
        }
    
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) 
        {
            temp = temp.next;
        }
        if (temp.next != null) 
        {
            temp.next = temp.next.next;
        }
    }
}