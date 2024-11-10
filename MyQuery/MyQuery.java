package MyQuery;
public class MyQuery<E>
{
    Node<E> head;
    Node<E> tail;

    public void enqueue(E data)
    {
        Node<E> newNode = new Node<E>(data);
        if (head==null) 
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
    public E dequeue()
    {
        Node<E> temp = head;
        if (head==null) System.out.println("Queue is Empty!");
        else
        {
            head=head.next;
        }
        return temp.data;
    }
    public Node<E> getNode(int index)
    {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) 
        {
            temp=temp.next;
        }
        return temp;
    }
    public int length()
    {
        int counter=0;
        if (head==null) System.out.println("Queue is Empty!");
        else
        {
            Node<E> temp = head;
            while (temp!=null) 
            {
                counter++;
                temp=temp.next;
            }
        }
        return counter;
    }
    public void print()
    {
        Node<E> temp = head;
        System.out.print("Start <- ");
        while (temp!=null) 
        {
            System.out.print(temp.data + " <- ");
            temp=temp.next;    
        }
        System.out.println("End");
    }
    public void BubbleSort()
    {
        boolean swapped=false;
        for (int i = 0; i < length()-1; i++) 
        {
            for (int j = 0; j < length()-1-i; j++) 
            {
                if (((Comparable<E>) getNode(j).data).compareTo(getNode(j + 1).data) > 0) 
                {
                    E temp = getNode(j).data;
                    getNode(j).data=getNode(j+1).data;
                    getNode(j+1).data = temp;
                    swapped=true;
                }
            }
            if (!swapped) 
            {
                break;
            }
        }
    }
    public void SelectionSort()
    {
        int i;E min;int minIndex;
        for (i = 0; i < length(); i++) 
        {
            min=getNode(i).data;
            minIndex=i;
            for (int j = i+1; j < length(); j++) 
            {
                if (((Comparable<E>) getNode(j).data).compareTo(min) < 0)
                {
                    min=getNode(j).data;
                    minIndex=j;    
                }
            }
            getNode(minIndex).data=getNode(i).data;
            getNode(i).data=min;
        }
    }
    private void Merge(MyQuery<E> queue, MyQuery<E> leftQueue, MyQuery<E> rightQueue) 
    { 
        int i = 0, j = 0, k = 0;
        int leftLength = leftQueue.length();
        int rightLength = rightQueue.length();
        while (i < leftLength && j < rightLength) 
        {
            if (((Comparable<E>) leftQueue.getNode(i).data).compareTo(rightQueue.getNode(j).data) <= 0) {
                queue.getNode(k++).data = leftQueue.getNode(i++).data;
            } 
            else 
            {
                queue.getNode(k++).data = rightQueue.getNode(j++).data;
            }
        }
        while (i < leftLength) 
        {
            queue.getNode(k++).data = leftQueue.getNode(i++).data;
        }
        while (j < rightLength) 
        {
            queue.getNode(k++).data = rightQueue.getNode(j++).data;
        }
    }
    public void MergeSort(MyQuery<E> queue) 
    {
        if (queue.length() <= 1) return;
        int mid = queue.length() / 2;
        MyQuery<E> leftQueue = new MyQuery<>();
        MyQuery<E> rightQueue = new MyQuery<>();
        for (int i = 0; i < mid; i++) 
        {
            leftQueue.enqueue(queue.getNode(i).data);
        }
        for (int i = mid; i < queue.length(); i++) 
        {
            rightQueue.enqueue(queue.getNode(i).data);
        }
        MergeSort(leftQueue);
        MergeSort(rightQueue);
        Merge(queue, leftQueue, rightQueue);
    }
}
