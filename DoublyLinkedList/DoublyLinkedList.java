class Link {
	public Object data;
	public Link next;
	public Link previous;

	public Link(Object o) {
		data = o;
	}

	public String toString() {
		return data.toString();
	}
}

@SuppressWarnings("all")
class DoublyLinkedList {
	private Link first; // reference to first link on list
	private Link last; // reference to first link on list

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(Object d) {
		Link newLink = new Link(d);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(Object d) {
		Link newLink = new Link(d);
		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Object removeFirst() {
		Object tmp = first.data;
		if (first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		return tmp;
	}

	public Object removeLast() {
		Object tmp = last.data;
		if (first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return tmp;
	}

	public Object getFirst() {
		return first.data;
	}

	public Object getLast() {
		return last.data;
	}

	public void displayForward() {
		System.out.print("[ ");
		Link curr = first;
		while (curr != null) {
			System.out.print(curr + " ");
			curr = curr.next;
		}
		System.out.println("]");
	}

	public void displayBackward() {
		System.out.print("[ ");
		Link curr = last;
		while (curr != null) {
			System.out.print(curr + " ");
			curr = curr.previous;
		}
		System.out.println("]");
	}

	// EX81
	public int counterIter() {
		if (first == null)
			return 0;
		Link curr = first;
		int x = 0;
		while (curr != null) {
			curr = curr.next;
			x++;
		}
		return x;
	}

	public int counterRec() {
		return counterRec(first);
	}

	private int counterRec(Link l) {
		if (l == null)
			return 0;
		return counterRec(l.next) + 1;
	}

	// EX82
	public Link max() {
		if (first == null)
			return null;

		Link curr = first;
		Link max = first;
		while (curr != null) {
			if ((int) curr.data > (int) max.data) {
				max = curr;
				curr = curr.next;
			}
		}
		return max;
	}

	// EX83
	public boolean contains(Object o) {
		if (first == null)
			return false;
		Link curr = first;
		while (curr != null) {
			if ((int) curr.data == (int) o)
				return true;
			curr = curr.next;
		}
		return false;
	}

	public boolean containsRec(Object o) {
		return containsRec(first, o);
	}

	private boolean containsRec(Link l, Object o) {
		if (l == null)
			return false;
		if ((int) l.data == (int) o)
			return true;
		return containsRec(l.next, o);
	}

	// EX85
	public boolean insertAfter(Object key, Object dd) {
		Link curr = first;
		while (!curr.data.equals(key)) {
			curr = curr.next;
			if (curr == null)
				return false;
		}
		Link newLink = new Link(dd);
		if (curr == last) {
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = curr.next;
			curr.next.previous = newLink;
		}
		newLink.previous = curr;
		curr.next = newLink;
		return true;
	}

	public boolean insertBefore(Object key, Object dd) {
		Link curr = first;
		while (!curr.data.equals(key)) {
			curr = curr.next;
			if (curr == null)
				return false;
		}
		Link newLink = new Link(dd);
		if (curr == first) {
			newLink.next = first;
			first = newLink;
		} else {
			newLink.next = curr;
			curr.previous.next = newLink;
		}
		newLink.previous = curr.previous;
		curr.previous = newLink;
		return true;
	}

	public Object deleteKey(Object key) {
		Link curr = first;
		while (curr != null && !curr.equals(key)) {
			curr = curr.next;
		}
		if (curr == null) {
			System.out.println("Object not found");
			return null;
		}
		if (curr == first)
			first = curr.next;
		else
			curr.previous.next = curr.next;

		if (curr == last)
			last = curr.previous;
		else
			curr.next.previous = curr.previous;

		return curr.data;
	}

	public void insertToSorted(Comparable x) {
		Link curr = first;
		Link tmp = new Link(x);
		if (first == null) {
			first = tmp;
			last = tmp;
			return;
		}
		while (curr != null) {
			if (x.compareTo(curr.data) < 0) {
				tmp.next = curr;
				tmp.previous = curr.previous;
				if (curr.previous != null) {
					curr.previous.next = tmp;
				} else {
					first = tmp;
				}
				curr.previous = tmp;
				break;

			}
			if (curr.next == null) {
				curr.next = tmp;
				tmp.previous = curr;
				last = tmp;
				break;
			}
			curr = curr.next;
		}

	}

	public void insertionSort() {
		DoublyLinkedList temp = new DoublyLinkedList();
		Link current = first;
		while (current != null) {
			temp.insertToSorted((Comparable) current.data);
			current = current.next;
		}
		first = temp.first;
		last = temp.last;
	}

	public int countIter() {
		Link curr = first;
		int x = 0;
		while (curr != last) {
			curr = curr.next;
			x++;
		}
		return x;
	}

	public int countRec() {
		return countRec(first);
	}

	private int countRec(Link l) {
		if (l == null)
			return 0;
		else
			return countRec(l.next) + 1;
	}

	//Reverse and reverseRec
}