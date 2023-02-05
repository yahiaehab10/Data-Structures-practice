public class CircularLinkedList {
    private Link last;

    public CircularLinkedList() {
        last = null;
    }

    public void insertFirst(Object o) {
        Link newLink = new Link(o);
        if (last == null)
            last = newLink;
        else
            newLink.next = last.next;
        last.next = newLink;
    }

    public void insertLast(Object o) {
        Link newLink = new Link(o);
        if (last == null) {
            last = newLink;
            last.next = newLink;
        } else {
            newLink.next = last.next;
            last.next = newLink;
            last = newLink;
        }

    }

    public Object removeFirst() {
        Object temp = null;
        if (last.next == last) {
            temp = last.data;
            last = null;
        } else {
            temp = last.next.data;
            last.next = last.next.next;
        }
        return temp;
    }

    public Object removeLast() {
        Object temp = last.data;
        if (last.next == last)
            last = null;
        else {
            Link current = last;
            while (current.next != last)
                current = current.next;
            current.next = current.next.next;
            last = current;
        }
        return temp;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public String toString() {
        String res = "[ ";
        if (!isEmpty()) {
            Link current = last.next;
            do {
                res += current.data + " ";
                current = current.next;
            } while (current != last.next);
        }
        res += "]";
        return res;
    }

    public void append(CircularLinkedList l2) {
        if (last == null) {
            last = l2.last;
        } else {
            Link first = last.next;
            last.next = l2.last.next;
            l2.last.next = first;
            last = l2.last;
        }
    }

}