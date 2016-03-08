/**
 * Created by qazimusab on 3/6/16.
 */
@SuppressWarnings("unused")
public class SinglyLinkedList <Type> {

    private Node<Type> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Type data) {
        if(head == null) {
            head = new Node<>(data);
        }
        else {
            Node<Type> nodeToAdd = new Node<>(data);
            Node<Type> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = nodeToAdd;
        }
        size++;
    }

    public void add(Type data, int index) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(data == null) {
            throw new NullPointerException();
        }
        if(index == size) {
            add(data);
            return;
        }
        if(index == 0) {
            Node<Type> oldHeadNode = head;
            Node<Type> newHeadNode = new Node<>(data, oldHeadNode);
            head = newHeadNode;
        }
        else {
            Node<Type> nodeBeforeIndex = getNode(index - 1);
            Node<Type> nodeToAdd = new Node<>(data, nodeBeforeIndex.next);
            nodeBeforeIndex.next = nodeToAdd;
        }
    }

    public Type get(int index) {
        Node<Type> iterator = head;
        for (int i = 1; i <= index; i++) {
            iterator = iterator.next;
        }
        return iterator.data;
    }

    private Node<Type> getNode(int index) {
        Node<Type> iterator = head;
        for (int i = 1; i <= index; i++) {
            iterator = iterator.next;
        }
        return iterator;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(head == null) {
            return "LinkedList is empty.";
        }
        stringBuilder
                .append(head.data)
                .append("->");
        if(head.next == null) {
            stringBuilder
                    .append("NULL");
            return stringBuilder.toString();
        }
        Node<Type> iterator = head;
        while (iterator.next != null) {
            iterator = iterator.next;
            stringBuilder
                    .append(iterator.data)
                    .append("->");
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public class Node<T> {

        public T data;
        public Node<T> next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }

}
