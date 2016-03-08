/**
 * Created by qazimusab on 3/6/16.
 */
public class DoublyLinkedList <Type>  {

    public enum PRINT{
        FORWARD,
        BACKWARD
    }

    private Node<Type> head;
    private Node<Type> tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void add(Type data) {
        Node<Type> newTail = new Node<>(data);
        if(head == null) {
            head = newTail;
            tail = head;
        }
        else {
            if(head == tail){
                tail = newTail;
                tail.prev = head;
                head.next = tail;
            }
            else {
                Node<Type> oldTail = tail;
                tail = newTail;
                tail.prev = oldTail;
                oldTail.next = tail;
            }
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
            Node<Type> newHeadNode = new Node<>(data, oldHeadNode, null);
            head = newHeadNode;
        }
        else {
            Node<Type> nodeOriginallyAtIndex = getNode(index);
            Node<Type> nodeToAdd = new Node<>(data, nodeOriginallyAtIndex, nodeOriginallyAtIndex.prev);
            nodeOriginallyAtIndex.prev.next = nodeToAdd;
            nodeOriginallyAtIndex.prev = nodeToAdd;
        }
    }

    public int size() {
        return size;
    }

    public Type get(int index) {
        return getNode(index).data;
    }

    private Node<Type> getNode(int index) {
        Node<Type> iteratorToIndex;
        if(index < size / 2) {
            iteratorToIndex = head;
            for (int i = 1; i <= index; i++) {
                iteratorToIndex = iteratorToIndex.next;
            }
        }
        else {
            iteratorToIndex = tail;
            for (int i = size; i >= index; i--) {
                iteratorToIndex = iteratorToIndex.prev;
            }
        }
        return iteratorToIndex;
    }

    public String toString(PRINT print) {
        if (head == null) {
            return "LinkedList is empty.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        switch (print) {
            case FORWARD:
            stringBuilder
                    .append("NULL")
                    .append("->")
                    .append(head.data)
                    .append("->");
            if (head.next == null) {
                stringBuilder
                        .append("NULL");
                return stringBuilder.toString();
            }
            Node<Type> forwardIterator = head;
            while (forwardIterator.next != null) {
                forwardIterator = forwardIterator.next;
                stringBuilder
                        .append(forwardIterator.data)
                        .append("->");
            }
            stringBuilder.append("NULL");
                break;
            case BACKWARD:
                stringBuilder
                        .append("NULL")
                        .append("->")
                        .append(tail.data)
                        .append("->");
                if (tail.prev == null) {
                    stringBuilder
                            .append("NULL");
                    return stringBuilder.toString();
                }
                Node<Type> backwardIterator = tail;
                while (backwardIterator.prev != null) {
                    backwardIterator = backwardIterator.prev;
                    stringBuilder
                            .append(backwardIterator.data)
                            .append("->");
                }
                stringBuilder.append("NULL");
                break;
        }
        return stringBuilder.toString();
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

    public class Node<Type> {

        public Type data;
        public Node<Type> next;
        public Node<Type> prev;

        public Node() {

        }

        public Node(Type data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(Type data, Node<Type> next, Node<Type> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }
}
