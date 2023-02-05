@SuppressWarnings("all")
public class Test {

    public static DoublyLinkedList insertionSort(DoublyLinkedList list) {
        DoublyLinkedList sorted = new DoublyLinkedList();
        while (!list.isEmpty()) {
            if (sorted.isEmpty()) {
                sorted.insertFirst(list.removeFirst());
            } else {
                Object tempValue = list.removeFirst();
                DoublyLinkedList tempList = new DoublyLinkedList();
                boolean added = false;
                while (!added) {
                    if (sorted.isEmpty()) {
                        sorted.insertFirst(tempValue);

                        added = true;
                        break;
                    }
                    Comparable removed = (Comparable) sorted.removeFirst();
                    if (removed.compareTo(tempValue) < 0) {
                        tempList.insertLast(removed);
                    } else {
                        sorted.insertFirst(removed);
                        sorted.insertFirst(tempValue);
                        added = true;
                    }
                }
                while (!tempList.isEmpty()) {
                    sorted.insertFirst(tempList.removeLast());
                }
            }
        }
        return sorted;
    }

    public static int count(DoublyLinkedList l) {
        DoublyLinkedList l2 = new DoublyLinkedList();
        int count = 0;
        while (!l.isEmpty()) {
            l2.insertFirst(l.removeFirst());
            count++;
        }
        while (!l2.isEmpty()) {
            l.insertFirst(l2.removeFirst());
        }
        return count;
    }

    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        d.insertLast(1);
        d.insertLast(2);
        d.insertLast(3);
        d.insertLast(4);
        d.insertLast(5);
        d.insertLast(6);
        d.displayForward();
        System.out.println(d.containsRec(7));
    }
}
