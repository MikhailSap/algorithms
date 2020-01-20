package tree;

import java.util.NoSuchElementException;

public class MyTreeMap <Key extends Comparable<Key>, Value> {
    private Node root;
    private int size;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isKeyNotNull(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
        return true;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        Value value = get(key, root);
        if (value == null)
            throw new NoSuchElementException();
        return value;
    }

    private Value get(Key key, Node node) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(key, value, node.left);

        } else {
            node.right = put(key, value, node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = (height(node.left) > height(node.right) ? height(node.left) : height(node.right)) + 1;
        return node;
    }


    private Node min(Node node) {
        if (node.left == null)
        return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        Node left = node.left;
        Node right = node.right;
        if (left == null && right == null) {
            node.height = 0;
        } else {
            node.height = (height(left) > height(right) ? height(left) : height(right)) + 1;
        }
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        delete(key, root);
    }

    private Node delete(Key key, Node node) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(key, node.left);
        } else if (cmp > 0) {
            node.right = delete(key, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node tmp = node;
                node = min(node.right);
                node.right = deleteMin(tmp.right);
                node.left = tmp.left;
            }
        }
        node.size = size(node.left) + size(node.right) + 1;
        Node left = node.left;
        Node right = node.right;
        if (left == null && right == null) {
            node.height = 0;
        } else {
            node.height = (height(left) > height(right) ? height(left) : height(right)) + 1;
        }
        return node;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int leftHeight = node.left != null ? node.left.height : -1;
        int rightHeight = node.right != null ? node.right.height : -1;
        return !(Math.abs(leftHeight - rightHeight) > 1) && isBalanced(node.left) && isBalanced(node.right);
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null)
            return "";
        return "[" + node.key + "," + node.value + "," + node.size + "," + node.height + "]," + toString(node.left) +toString(node.right);
    }

    
    private class Node {
        private Key key;
        private Value value;
        private int size;
        private int height;

        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }
}
