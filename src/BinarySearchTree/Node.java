package BinarySearchTree;

public class Node {

    public int key;
    public String value;
    public Node left, right;


    public Node(int key, String value) {
        this.key = key;
        this.value = value;

    }
    Node node = this;
    public void insert(int key, String data) {
        Node node = this;

        if (node.key==key) {
            node.value = data;
        } else if (key > node.key) {
            if (node.right != null) {
                node = node.right;
                get(key);
            } else {
                node.right = new Node(key, data);
            }
        } else {
            if (node.left != null) {
                node = node.left;
                get(key);
            } else {
                node.left = new Node(key, data);
            }
        }
    }
    public Node get(int key) {

        if (node.key==key) {
            return node;
        }
        if (key > node.key) {
            node=node.right;
            get(key);
        }
        if (key < node.key) {
            node=node.right;
            get(key);
        }
        return get(key);


    }



    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}