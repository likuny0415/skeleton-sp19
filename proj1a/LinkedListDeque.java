public class LinkedListDeque<T> {

    /** nested class inside Deque */
    private class IntNode {
        public IntNode prev;
        private IntNode next;
        private T item;

        /** IntNode constructor */
        public IntNode(T item, IntNode prev, IntNode next) {
            item = item;
            prev = prev;
            next = next;
        }
    }

    /** fields */
    private IntNode sentinel;
    private int size;
    private IntNode last;

    /** empty deque */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** add an item to the front of the deque */
    public void addFirst(T x) {
        IntNode newNode = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /** add an item to the last of the deque */
    public void addLast(T x) {
        IntNode newNode = new IntNode(x, sentinel.next, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /** check if the given deque is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** return the number of items in this deque */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed,
     * print out a new line.
     */

    public void printDeque() {
        IntNode toPrint = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(toPrint.item + " ");
            toPrint = sentinel.next;
        }
        System.out.println();
    }

    /** Remove the first element, if no such item exists, return null */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return sentinel.item;
    }

    /** Remove the last element, if no such item exists, return null */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return sentinel.prev.item;
    }

    /** get the item at the given index,
     * where 0 is the front,
     * 1 is the next item,
     * and so forth. If no such item exists, returns null
     */
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        int i = 0;
        while (i < index) {
            sentinel = sentinel.next;
            i++;
        }
        return sentinel.next.item;
    }

    /** same at get, but recursive */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    /** getRecursive Helper */
    public T getRecursiveHelper(int index, IntNode n) {
        if (index == 0) {
            return n.item;
        }
        return getRecursiveHelper(index -= 1, n.next);
    }

    /** copy constructor */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new IntNode(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size; i++) {
            addLast((T)get(i));
        }
    }
}


