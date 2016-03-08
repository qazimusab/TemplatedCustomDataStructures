/**
 * Created by qazimusab on 3/7/16.
 */
@SuppressWarnings("unused")
public class BinarySearchTree <Type> {

    private Node root;
    public Comparor<Type> comparor;

    public BinarySearchTree(Comparor<Type> comparor) {
        this.comparor = comparor;
        root = null;
    }

    public BinarySearchTree(Type data, Comparor<Type> comparor) {
        this.comparor = comparor;
        root = new Node(data);
    }

    public void insert(Type data) {
        if(data == null) {
            throw new NullPointerException();
        }
        else {
            root = insert(root, new Node(data));
        }
    }

    private Node insert(Node root, Node nodeToInsert) {
        if(root == null) {
            return new Node(nodeToInsert.data);
        }
        else if (nodeToInsert.compareTo(root.data) > 0) {
            root.rightChild = insert(root.rightChild, nodeToInsert);
        }
        else if(nodeToInsert.compareTo(root.data) < 0) {
            root.leftChild = insert(root.leftChild, nodeToInsert);
        }
        return root;
    }

    public void printInOrder() {
        printInOrder(root);
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

    private class Node implements Comparable<Type> {

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
        public int compareTo(Type dataToCompare) {
            return comparor.compare(data, dataToCompare);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}