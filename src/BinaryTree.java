//create a generic Binary Search Tree

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<T>(data);
        } else {
            if (data.compareTo(node.getData()) <= 0) {
                node.setLeft(insert(node.getLeft(), data));
            } else {
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        } else {
            if (data.compareTo(node.getData()) < 0) {
                node.setLeft(delete(node.getLeft(), data));
            } else if (data.compareTo(node.getData()) > 0) {
                node.setRight(delete(node.getRight(), data));
            } else {
                if (node.getLeft() == null && node.getRight() == null) {
                    return null;
                } else if (node.getLeft() == null) {
                    return node.getRight();
                } else if (node.getRight() == null) {
                    return node.getLeft();
                } else {
                    T min = findMin(node.getRight());
                    node.setData(min);
                    node.setRight(delete(node.getRight(), min));
                }
            }
        }
        return node;
    }

    private T findMin(Node<T> node) {
        if (node.getLeft() == null) {
            return node.getData();
        } else {
            return findMin(node.getLeft());
        }
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        } else {
            if (data.compareTo(node.getData()) < 0) {
                return search(node.getLeft(), data);
            } else if (data.compareTo(node.getData()) > 0) {
                return search(node.getRight(), data);
            } else {
                return true;
            }
        }
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
