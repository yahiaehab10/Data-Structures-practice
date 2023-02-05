package LinkList;

public class Test {

    public static void insertLast(LinkList l, Object o) {
        LinkList tmp = new LinkList();
        while (!l.isEmpty())
            tmp.insertFirst(l.removeFirst());
        tmp.insertFirst(o);
        while (!tmp.isEmpty())
            l.insertFirst(tmp.removeFirst());
    }

    public static Object removeLast(LinkList l) {
        LinkList tmp = new LinkList();
        while (!l.isEmpty())
            tmp.insertFirst(l.removeFirst());
        Object res = tmp.removeFirst();
        while (!tmp.isEmpty())
            l.insertFirst(tmp.removeFirst());
        return res;
    }

    public static LinkList cut(LinkList l) {
        LinkList front = new LinkList();
        LinkList back = new LinkList();
        while (!l.isEmpty()) {
            front.insertLast(l.removeFirst());
            if (!l.isEmpty())
                back.insertFirst(l.removeLast());
        }
        while (!back.isEmpty()) {
            front.insertFirst(back.removeLast());
        }
        return front;

    }

    public static void frontBackSplit(LinkList l) {
        LinkList sub1 = new LinkList();
        LinkList sub2 = new LinkList();
        int x = 0;
        LinkList temp = new LinkList();
        while (!l.isEmpty()) {
            temp.insertLast(l.removeFirst());
            x++;
        }
        System.out.println("Size of Original Linklist is " + x);
        for (int i = 0; i < (x + 1) / 2; i++) {
            Object o = temp.removeFirst();
            l.insertLast(o);
            sub1.insertLast(o);
        }
        while (!temp.isEmpty()) {
            Object o = temp.removeFirst();
            l.insertLast(o);
            sub2.insertLast(o);
        }
        System.out.println("Sub List 1" + sub1);
        System.out.println("Sub List 2 " + sub2);

    }

    public static void alternatingSplit(LinkList list) {
        LinkList subList1 = new LinkList();
        LinkList subList2 = new LinkList();
        LinkList tempList = new LinkList();
        int count = 0;
        if (list.isEmpty()) {
            System.out.print("List is empty");
            return;
        }
        while (!list.isEmpty()) {
            Object temp = list.removeFirst();
            if (count % 2 == 0)
                subList1.insertLast(temp);
            else
                subList2.insertLast(temp);
            tempList.insertLast(temp);
            count++;
        }
        while (!tempList.isEmpty())
            list.insertLast(tempList.removeFirst());
        System.out.print("First sublist: ");
        System.out.print(subList1.toString() + " ");
        System.out.print("Second sublist: ");
        System.out.print(subList2.toString() + " ");
        System.out.println();
    }

    public static LinkList merge(LinkList x, LinkList y) {
        LinkList z = new LinkList();
        while (!x.isEmpty())
            z.insertLast(x.removeFirst());
        while (!y.isEmpty())
            z.insertLast(y.removeFirst());
        return z;
    }

    public static boolean equals(LinkList l1, LinkList l2) {
        LinkList temp1 = new LinkList();
        LinkList temp2 = new LinkList();
        boolean equal = true;
        while (!l1.isEmpty() && !l2.isEmpty() && equal) {
            Object o1 = l1.removeFirst();
            Object o2 = l2.removeFirst();
            if (!o1.equals(o2))
                equal = false;
            temp1.insertFirst(o1);
            temp2.insertFirst(o2);
        }
        if (equal)
            equal = l1.isEmpty() && l2.isEmpty();
        while (!temp1.isEmpty())
            l1.insertFirst(temp1.removeFirst());
        while (!temp2.isEmpty())
            l2.insertFirst(temp2.removeFirst());
        return equal;
    }

    public static LinkList intersection(LinkList x, LinkList y) {
        LinkList z = new LinkList();
        LinkList temp = new LinkList();
        while (!x.isEmpty()) {
            Object k = x.removeFirst();
            while (!y.isEmpty()) {
                temp.insertLast(y.getFirst());
                if (k.equals(y.removeFirst())) {
                    z.insertLast(k);
                    break;
                }
            }
            while (!temp.isEmpty()) {
                y.insertLast(temp.removeFirst());
            }
        }
        return z;
    }

    public static LinkList difference(LinkList x, LinkList y) {
        LinkList z = new LinkList();
        LinkList temp = new LinkList();
        while (!x.isEmpty()) {
            Object k = x.removeFirst();
            boolean flag = true;
            while (!y.isEmpty()) {
                temp.insertLast(y.getFirst());
                if (k.equals(y.removeFirst())) {
                    flag = false;
                    break;

                }
            }
            if (flag)
                z.insertLast(k);
            while (!temp.isEmpty()) {
                y.insertLast(temp.removeFirst());
            }
        }
        return z;
    }

    public static LinkList union(LinkList x, LinkList y) {
        return merge(difference(x, y), y);
    }

    public static void main(String[] args) {

        LinkList l = new LinkList();
        l.insertFirst(3);
        l.insertFirst(2);
        l.insertFirst(1);

        LinkList l2 = new LinkList();
        l2.insertFirst(6);
        l2.insertFirst(5);
        l2.insertFirst(4);

        l.merge(l2);
        System.out.println(l);

    }
}
