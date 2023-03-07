package BinarySearchTree;

public class NodeTree {

    public int key;//ключ ветки
    public String value;//элемент с ветки
    public NodeTree left, right;//левые и правые ветки


    public NodeTree(int key, String value) { //конструктор дерева
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

}