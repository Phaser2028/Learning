package HabrTasks.BinarySearchTree;

/**
 *  INPUT:
 *         String[] arr = new String[]{"name1","name2","name3","name4","name5"};
 *         int[] num = new int[]{10,4,51,2,434};
 *         NodeTree root = new NodeTree(0,"0");
 *         for (int i = 0; i < arr.length; i++) {
 *             BinaryTree.insert(root,num[i],arr[i]);
 *             System.out.println(BinaryTree.get(root,num[i]));
 *         }
 *  OUTPUT:
 *         Node{value=name1}
 *         Node{value=name2}
 *         Node{value=name3}
 *         Node{value=name4}
 *         Node{value=name5}
 */

public class BinaryTree {
    public static NodeTree get(NodeTree node, int key) {//рекурсивный метод получения ветки

        if (key == node.key) {//если ключи совпадают, то вернуть ветку
            return node;
        }

        if (node.right != null & key > node.key) {//проверка на наличие правой ветки
            node = node.right;
            get(node, key);
        } else if (node.right == null) {
            return node;
        }

        if (node.left != null & key < node.key) {//проверка на наличие левой ветки
            node = node.left;
            get(node, key);//вызов рекурсии
        } else if (node.left == null) {
            return node;
        }

        return get(node, key);//вызов рекурсии
    }


    public static void insert(NodeTree node, int key, String data) {//рекурсивный метод добавления ветки на дерево

        if (key == node.key) {//если ключи совпадают, то заменить значение элемента на ветке
            node.value = data;
        }

        if (node.right == null) {
            node.right = new NodeTree(key, data);
        }
        if (node.left == null) {
            node.left = new NodeTree(key, data);
        }

        if (key > node.key) {
            node = node.right;
            insert(node, key, data);//вызов рекурсии
        }


        if (key < node.key) {
            node = node.left;
            insert(node, key, data);//вызов рекурсии

        }
    }
}



