package LinkList;

class Link {
    public Object data;
    public Link next;

    public Link(Object o) {
        this.data = o;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }
}

class LinkList {
    private Link head;

    public LinkList() {
        head = null;
    }

    public void insertFirst(Object o) {
        Link newLink = new Link(o);
        newLink.next = head;
        head = newLink;
    }

    public Object removeFirst() {
        Object res = head.data;
        head = head.next;
        return res;
    }

    public Object getFirst() {
        return head.data;
    }

    public void insertLast(Object o) {
        Link newLink = new Link(o);
        if (head == null) {
            head = newLink;
            return;
        }
        Link current = head;
        while (current.next != null)
            current = current.next;
        current.next = newLink;
    }

    public Object removeLast() {
        if (head.next == null) {
            Object res = head.data;
            head = null;
            return res;
        }
        Link current = head;
        while (current.next.next != null)
            current = current.next;
        Object res = current.next.data;
        current.next = null;
        return res;
    }

    public Object getLast() {
        Link current = head;
        while (current.next != null)
            current = current.next;
        return current.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        if (head == null)
            return "[ ]";
        String res = "[ " + head.data;
        Link current = head.next;
        while (current != null) {
            res += ", " + current.data;
            current = current.next;
        }
        res += " ]";
        return res;
    }

    // EX7-1
    public void insertLastRec(Object o) {
        if (head == null)
            head = new Link(o);
        else
            insertLastRec(head, o);
    }

    private void insertLastRec(Link l, Object o) {
        if (l.next == null)
            l.next = new Link(o);
        else
            insertLastRec(l.next, o);
    }

    // ex7-2
    public LinkList reverse() {
        LinkList res = new LinkList();
        Link curr = head;
        while (curr != null) {
            res.insertFirst(curr.data);
            curr = curr.next;
        }

        return res;
    }

    // ex7-3
    public void reverseInPlace() {
        Link curr = head.next;
        Link prev = head;
        while (curr != null) {
            Link tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        head.next = null;
        head = prev;
    }

    // remove dups
    public static void removeDuplicates(LinkList l) {
        LinkList tempList = new LinkList();
        tempList.insertLast(l.removeFirst());
        while (!l.isEmpty()) {
            if (!l.getFirst().equals(tempList.getLast()))
                tempList.insertLast(l.removeFirst());
            else
                l.removeFirst();
        }
        while (!tempList.isEmpty())
            l.insertLast(tempList.removeFirst());
    }

    // mix elements
    public LinkList mixElements(LinkList l) {
        LinkList res = new LinkList();
        Link curr1 = head;
        Link curr2 = l.head;
        while (curr1 != null && curr2 != null) {
            if (curr1 != null) {
                res.insertLast(curr1.data);
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                res.insertLast(curr2.data);
                curr2 = curr2.next;
            }

        }
        return res;
    }

    // Print Middle Value
    public void printMiddle() {
        int x = 0;
        Link curr = head;
        while (curr.next != null) {
            x++;
            curr = curr.next;
        }
        curr = head;
        x /= 2;
        while (x != 0) {
            curr = curr.next;
            x--;
        }
        System.out.println(curr.data);
    }

    public void cutList() {
        int x = 0;
        Link curr = head;
        while (curr != null) {
            curr = curr.next;
            x++;
        }
        for (int i = 0; i < x / 2; i++) {
            insertFirst(removeLast());
        }
    }

    public void merge(LinkList l) {
        Link curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = l.head;
    }

    public boolean equals(LinkList l) {
        Link c1 = this.head;
        Link c2 = l.head;
        while (c1 != null && c2 != null) {
            if (!c1.data.equals(c2.data))
                return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1 == null && c2 == null;
    }

    public boolean contains(Object o) {
        Link current = head;
        while (current != null) {
            if (current.data.equals(o))
                return true;
            current = current.next;
        }
        return false;
    }

    public LinkList intersection(LinkList l) {
        LinkList result = new LinkList();
        Link current = head;
        while (current != null) {
            if (l.contains(current.data))
                result.insertLast(current.data);
            current = current.next;
        }
        return result;
    }

    public LinkList difference(LinkList l) {
        LinkList result = new LinkList();
        Link current = head;
        while (current != null) {
            if (!l.contains(current.data))
                result.insertLast(current.data);
            current = current.next;
        }
        return result;
    }


    //2019 Question
    public static LinkList commonElements(LinkList l1 , LinkList l2){
        LinkList res = new LinkList();
        Link c1 = l1.head;Link c2 = l2.head;
        while (c1 != null) {
            while (c2 != null) {
                if ((int)c1.data == (int)c2.data) {
                    res.insertLast(c1.data);
                    c2 = c2.next;
                } else 
                    c2 = c2.next;
            }
            c2 =l2.head;
            c1 = c1.next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkList l = new LinkList();
        l.insertFirst(21);
        l.insertFirst(15);
        l.insertFirst(12);
        l.insertFirst(9);
        l.insertFirst(3);

        LinkList l2 = new LinkList();
        l2.insertFirst(19);
        l2.insertFirst(12);
        l2.insertFirst(6);
        l2.insertFirst(3);
        l2.insertFirst(2);

        LinkList res = commonElements(l, l2);
        System.out.println(res);
    }
}
