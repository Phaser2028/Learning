public class LinkedListNode<T> {

    Node<T> head;
    Node<T> tail;


    public void addNode(Node<T> head,T value){

        Node<T> current = head;
        if (current == null){
            current.setNext(tail);
            tail.setValue(value);
            tail.setNext(null);
        }
        if(current.getNext()==null){
            current.setNext(tail);
            tail.setValue(value);
            tail.setNext(null);
        }

        while (current.getNext()!=null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
        tail = current.getNext();
        tail.setValue(value);
        tail.setNext(null);
    }
    //вывести на экран все значения из цепи
    public void printNodes(Node<T> head){
        Node<T> a = head;
        while (a!=null){
            System.out.println(a.getValue());
            a=a.getNext();
        }
    }
}
