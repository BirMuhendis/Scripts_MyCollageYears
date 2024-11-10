package MyStack;
public class MyStack<E> 
{
    Node<E> top = null; 
    
    public void push(E data)
    {
        Node<E> newNode = new Node<E>(data);
        newNode.next=top;
        top=newNode;
    }
    public E pop()
    {
        Node<E> temp = top;
        top=top.next;
        return temp.data;
    }
    public void print()
    {
        if (top==null) System.out.println("stack is Empty!");
        else
        {
            Node<E> temp = top;
        while (temp!=null) 
        {
            System.out.print("| ");
            System.out.print(temp.data);
            temp=temp.next;  
            System.out.println(" |");
        }
        }
    }
    public void clearStack()
    {
        top=null;
    }
    public int length()
    {
        int counter=0;
        if (top==null) counter=0; 
        else
        {
            Node<E> temp=top;
            while (temp!=null) 
            {
                counter++;
                temp=temp.next;
            }
        }
        return counter;
    }
    public Node<E> getNode(int index)
        {
            Node<E> temp = top;
            for (int i = 0; i < index; i++) 
            {
                temp=temp.next;
            }
            return temp;
        }
    public Node<E> peek()
    {
        return top;
    }    
    public boolean isEmpty()
    {
        return top==null;
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
    private void Merge(MyStack<E> stack, MyStack<E> lefStack, MyStack<E> righStack) 
    { 
        int i = 0, j = 0, k = 0;
        int leftLength = lefStack.length();
        int rightLength = righStack.length();
        while (i < leftLength && j < rightLength) {
            if (((Comparable<E>) lefStack.getNode(i).data).compareTo(righStack.getNode(j).data) <= 0) {
                stack.getNode(k++).data = lefStack.getNode(i++).data;
            } else {
                stack.getNode(k++).data = righStack.getNode(j++).data;
            }
        }
        while (i < leftLength) 
        {
            stack.getNode(k++).data = lefStack.getNode(i++).data;
        }
        while (j < rightLength) 
        {
            stack.getNode(k++).data = righStack.getNode(j++).data;
        }
        }
    public void MergeSort(MyStack<E> stack) 
    {
        if (stack.length() <= 1) return;
        int mid = stack.length() / 2;
        MyStack<E> lefStack = new MyStack<>();
        MyStack<E> righStack = new MyStack<>();
        for (int i = 0; i < mid; i++) {
            lefStack.push(stack.getNode(i).data);
        }
        for (int i = mid; i < stack.length(); i++) {
            righStack.push(stack.getNode(i).data);
        }
        MergeSort(lefStack);
        MergeSort(righStack);
        Merge(stack, lefStack, righStack);
    }
}
