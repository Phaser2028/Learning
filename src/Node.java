
public class Node<T>{
     T value; //значение хранимое в цепи
    Node<T> prev;//предыдущий элемент цепи
     Node<T> next;//следующий элемент цепи



    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }



}

