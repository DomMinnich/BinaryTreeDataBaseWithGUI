//create a generic Binary Tree class (there will no duplicates in the data)

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void add(T data) {
        root = add(root, data);
    }

    private Node<T> add(Node<T> node, T data) {
        if (node == null) {
            node = new Node<T>(data);
        } else {
            if (data.compareTo(node.getData()) <= 0) {
                node.setLeft(add(node.getLeft(), data));
            } else {
                node.setRight(add(node.getRight(), data));
            }
        }
        return node;
    }

    public void print() {
        print(root);
    }

    private void print(Node<T> node) {
        if (node != null) {
            print(node.getLeft());
            System.out.println(node.getData());
            print(node.getRight());
        }
    }

}