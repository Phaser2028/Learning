package BinarySearchTree;

public class NodeTree {

    public int key;//ключ ветки
    public String value;//элемент с ветки
    public NodeTree left, right;//левые и правые ветки
    public NodeTree parent;

    public NodeTree(int key, String value, NodeTree parent) { //конструктор дерева
        this.key = key;
        this.value = value;
        this.parent = parent;

    }
    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

}