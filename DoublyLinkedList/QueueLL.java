public class QueueLL {
    DoublyLinkedList Queue;

    public QueueLL() {
        new DoublyLinkedList();
    }

    public void enqueue(Object o) {
        Queue.insertLast(o);
    }

    public Object dequeue() {
        return Queue.removeFirst();
    }

    public int size() {
        DoublyLinkedList tmp = new DoublyLinkedList();
        int x = 0;
        for (int i = 0; !Queue.isEmpty(); i++) {
            tmp.insertLast(Queue.removeFirst());
            x = i;
        }
        while (!tmp.isEmpty()) {
            Queue.insertLast(tmp.removeFirst());
        }
        return x;

    }

    public boolean isEmpty() {
        return Queue.isEmpty();
    }
}
