package BinarySearchTree;

public class Node {

    public int key;
    public String value;
    public Node left, right;


    public Node(int key, String value) {
        this.key = key;
        this.value = value;

    }

    public static Node get(Node node, int key) {

        if (node.right != null) {
            if (key > node.key) {
                node = node.right;
                get(node, key);
            }
        }

        if (node.left != null) {
            if (key < node.key) {
                node = node.left;
                get(node, key);
            }
        } else {
            return node;
        }
        return get(node, key);
    }

    public static void insert(Node node, int key, String data) {


        if (node.key == key) {
            node.value = data;
        }
        if (key > node.key) {
            if (node.right != null) {
                node = node.right;
                insert(node, key,data);
            } else {
                node.right = new Node(key, data);
            }
        } else {
            if (node.left != null) {
                node = node.left;
                insert(node, key,data);
            } else {
                node.left = new Node(key, data);
            }
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}