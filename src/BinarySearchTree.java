/**
 * Created by qazimusab on 3/7/16.
 */
@SuppressWarnings("unused")
public class BinarySearchTree <Type> {

    private Node root;
    private int size;
    public Comparor<Type> comparor;

    public BinarySearchTree(Comparor<Type> comparor) {
        this.comparor = comparor;
        root = null;
        size = 0;
    }

    public BinarySearchTree(Type data, Comparor<Type> comparor) {
        this.comparor = comparor;
        size = 0;
        if(data != null) {
            root = new Node(data);
            size++;
        }
        else {
            throw new NullPointerException();
        }
    }

    public void insert(Type data) {
        if(data == null) {
            throw new NullPointerException();
        }
        else {
            root = insert(root, new Node(data));
            size++;
        }
    }

    private Node insert(Node root, Node nodeToInsert) {
        if(root == null) {
            return new Node(nodeToInsert.data);
        }
        else if (nodeToInsert.compareTo(root) > 0) {
            root.rightChild = insert(root.rightChild, nodeToInsert);
        }
        else if(nodeToInsert.compareTo(root) < 0) {
            root.leftChild = insert(root.leftChild, nodeToInsert);
        }
        return root;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public int size() {
        return size;
    }

    private void printInOrder(Node root) {
        if(root == null) {
            return;
        }
        if (root.leftChild != null) {
            printInOrder(root.leftChild);
        }
        System.out.println(root.data);
        if(root.rightChild != null) {
            printInOrder(root.rightChild);
        }

    }

    private boolean find(Node root, Node nodeToFind) {
        boolean found;
        if(root == null || nodeToFind == null) {
            found = false;
        }
        else if(nodeToFind.compareTo(root) == 0) {
            found = true;
        }
        else if(nodeToFind.compareTo(root) < 0) {
            found = find(root.leftChild, nodeToFind);
        }
        else {
            found = find(root.rightChild, nodeToFind);
        }
        return found;
    }

    public boolean find(Type node) {
        return find(root, new Node(node));
    }

    private String toStringHelper(Node root, StringBuilder stringBuilder) {
        if(root == null) {
            return "";
        }
        if (root.leftChild != null) {
            toStringHelper(root.leftChild, stringBuilder);
        }
        stringBuilder.append(root.data).append("\n");
        if (root.rightChild != null) {
            toStringHelper(root.rightChild, stringBuilder);
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return toStringHelper(root, stringBuilder);
    }

    interface Comparor<Type> {
        /**
         * The purpose of this method is for the user of the BinarySearchTree to judge what makes dataInCurrentNode greater than, less than,
         * or equal to dataToCompare. The return MUST be 0, -1, or 1
         * @param dataInCurrentNode
         * @param dataToCompare
         * @return 0 if both are equal, 1 if dataInCurrentNode is greater than dataToCompare, and -1 if dataInCurrentNode is less than dataToCompare
         */
        int compare(Type dataInCurrentNode, Type dataToCompare);
    }

    private class Node implements Comparable<Node> {

        public Node leftChild;
        public Node rightChild;
        public Type data;

        public Node() {
            leftChild = null;
            rightChild = null;
            data = null;
        }

        public Node(Type data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
        }

        public Node(Type data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public int compareTo(Node dataToCompare) {
            return comparor.compare(data, dataToCompare.data);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}