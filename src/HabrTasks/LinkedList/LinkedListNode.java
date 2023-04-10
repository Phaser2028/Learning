package HabrTasks.LinkedList;

public class LinkedListNode<T> {

    public void addNode(Node<T> head,T value){ //добавить элемент в конец цепи
        Node<T> current = head;

        if (current.getNext() == null){
            Node<T> tail = new Node<>(value,current,null);
            current.setNext(tail);
        }

        while (current.getNext()!=null) {
            current = current.getNext();
        }

        current.setNext(new Node<>(value, current, null));
    }

    public T getNode(Node<T> head, int index){ //получуить элемент из цепи по индексу
        int s=0;
        Node<T> current=head;

        while (s!=index){
            current = current.getNext();
            s++;
        }
       return current.getValue();
    }

    public void printNodes(Node<T> head){ //вывести на экран все значения из цепи
        Node<T> a = head;
        while (a!=null){
            System.out.println(a.getValue());
            a=a.getNext();
        }
    }
}
