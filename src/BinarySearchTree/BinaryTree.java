package BinarySearchTree;

public class BinaryTree {
    public static NodeTree get(NodeTree node, int key) {//рекурсивный метод получения ветки

        if (key == node.key) {
            return node;
        }


        if (node.right != null & key > node.key) {//проверка на наличие правой ветки
            node = node.right;
            get(node, key);
        } else if(node.right == null) {
            return node;
        }

        if (node.left == null) {//проверка на наличие левой ветки
            return node;
        } else {
            if (key < node.key) {
                node = node.left;
                get(node, key);//рекурсия
            }
        }
        return get(node, key);
    }


    public static void insert(NodeTree node, int key, String data) {//рекурсивный метод добавления ветки на дерево

        if (key == node.key) {
            node.value = data;
        }


        if(node.right == null){
            node.right=new NodeTree(key, data, node);
        }
        if(node.left == null){
            node.left=new NodeTree(key, data, node);
        }

        if (key > node.key) {
                node = node.right;
                insert(node, key,data);
            }



        if(key < node.key) {
            node = node.left;
            insert(node, key,data);

            }
        }
    }



