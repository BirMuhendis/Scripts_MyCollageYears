public class MyLinkedList<E> 
{
        Node<E> head=null;
        Node<E> tail=null;
        public void add(E data)
        {
            Node <E> newNode= new Node<E>(data);
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
        public void removeLast()
        {
            Node<E> temp = head;
            if (head==null) 
            {
                System.out.println("List is Empty!");
            }
            else 
            {
                while (temp.next.next!=null) 
                {
                    temp=temp.next;
                }
                temp.next=null;
                tail = temp;
            }
        }
        public void removeFirst()
        {
            head=head.next;
        }
        public int length()
        {   
            int counter = 0;
            if (head==null) 
            {
                return counter;
            } 
            else 
            {
            Node<E> temp = head;
            while (temp!=null) 
            {
                counter++;
                temp = temp.next;
            }
            return counter;
            }
        }
        public void removeAtIndex(int index) 
        {
            if (index < 0 || index >= length()) 
            {
                System.out.println("This index cannot be!");
                return;
            }
            
            if (index == 0) 
            {
                removeFirst();
                return;
            }
            
            if (index == length() - 1) 
            {
                removeLast();
                return;
            }
        
            Node<E> temp = head;
            for (int i = 1; i < index; i++) 
            {
                temp = temp.next;
            }
            System.out.println(temp.next.data + "/*/*/*/*");
            temp.next = temp.next.next;
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
        @SuppressWarnings("unchecked")
        public void BubbleSort()
        {
            boolean swapped;
            for (int i = 0; i < length() - 1; i++) 
            {
                swapped = false;
                for (int j = 0; j < length() - 1 - i; j++) 
                {
                    if (((Comparable<E>) getNode(j).data).compareTo(getNode(j + 1).data) > 0) 
                    {
                        E temp = getNode(j).data;
                        getNode(j).data = getNode(j + 1).data;
                        getNode(j + 1).data = temp;
                        swapped = true;
                    } 
                }
                if (!swapped) 
                {
                    break;
                }
            }
        } 
        @SuppressWarnings("unchecked")
        public void SelectionSort()
        {
            E min;  int minIndex;   int i;
            for ( i = 0 ; i < length() ; i++) 
            {
                min = getNode(i).data;
                minIndex = i ;
                for (int j = i+1; j < length() ; j++)
                {
                    if (((Comparable<E>)getNode(j).data).compareTo(min) < 0) 
                    {
                        min= getNode(j).data;
                        minIndex=j;
                    }
                }
                getNode(minIndex).data=getNode(i).data;
                getNode(i).data=min;
            }
        }
        @SuppressWarnings("unchecked")
        private void Merge(MyLinkedList<E> list, MyLinkedList<E> leftList, MyLinkedList<E> rightList) { 
            int i = 0, j = 0, k = 0;
            int leftLength = leftList.length();
            int rightLength = rightList.length();
            while (i < leftLength && j < rightLength) {
                if (((Comparable<E>) leftList.getNode(i).data).compareTo(rightList.getNode(j).data) <= 0) {
                    list.getNode(k++).data = leftList.getNode(i++).data;
                } else {
                    list.getNode(k++).data = rightList.getNode(j++).data;
                }
            }
            while (i < leftLength) {
                list.getNode(k++).data = leftList.getNode(i++).data;
            }
            while (j < rightLength) {
                list.getNode(k++).data = rightList.getNode(j++).data;
            }
        }
        public void MergeSort(MyLinkedList<E> list) {
            if (list.length() <= 1) return;
            int mid = list.length() / 2;
            MyLinkedList<E> leftList = new MyLinkedList<>();
            MyLinkedList<E> rightList = new MyLinkedList<>();
            for (int i = 0; i < mid; i++) {
                leftList.add(list.getNode(i).data);
            }
            for (int i = mid; i < list.length(); i++) {
                rightList.add(list.getNode(i).data);
            }
            MergeSort(leftList);
            MergeSort(rightList);
            Merge(list, leftList, rightList);
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
        public void printlist()
        {
            if (head==null) System.out.println("List is Empty!");
            else
            {
                Node<E> temp = head;
                System.out.print("Start -> ");
                while (temp!=null) 
                {
                    System.out.print(temp.data+" -> ");
                    temp=temp.next;
                }
                System.out.println("End");
            }
    }

    public void Add(E data, int index) 
    {
        Node<E> newNode = new Node<E>(data);
        if (head == null) 
        {
            head = newNode;
            tail = newNode;
        } else if (index == 0) 
        {
            newNode.next = head;
            head = newNode;
        } 
        else 
        {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) 
            {
                if (temp == null) 
                {
                    throw new IndexOutOfBoundsException("Index is out of bounds");
                }
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = newNode;
                tail = newNode; 
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }
}
