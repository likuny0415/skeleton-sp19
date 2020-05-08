public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** constructor */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /**
     * resize the array
     */
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newArray, 0,size);
        items = newArray;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /** half the length of the items */
    public void downsize() {
        resize(size * 2);
    }

    /** if the items are full, then increase the length of the array */
    public void upsize() {
        resize(size / 2);
    }

    /**
     * add an item to the front of the array
     */
    public void addFirst(T item) {
        if (items.length == size) {
            upsize();
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }


    /** minusOne method
     * Tip: helps to get the position of nextFirst
     */
    public int minusOne(int n) {
        return (n - 1 + items.length) % items.length;
    }

    /**
     * add an item to the last of the array 8?
     */
    public void addLast(T item) {
        if (items.length == size) {
            resize(size);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    /** plusOne helper method
     * Tip: helps to get the position of nextLast
     */
    public int plusOne(int n) {
        return (n + 1) % items.length;
    }

    /** check if the given array is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** print the deqeu */
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** remove the first item from the deque 8 */
    public T removeFirst() {
        if (!isEfficiency()) {
            upsize();
        }
        nextFirst = plusOne(nextFirst);
        T firstToRemove = items[nextFirst];
        items[nextFirst] = null;

        if (isEmpty()) {
            return null;
        }
        size -= 1;
        return firstToRemove;
    }

    /** remove the last item from the deque */
    public T removeLast() {
        if (!isEfficiency()) {
            downsize();
        }
        nextLast = minusOne(nextLast);
        T lastItem = items[nextLast];
        items[nextLast] = null;

        if (isEmpty()) {
            return null;
        }
        size -= 1;
        return lastItem;
    }

    /** get the item at the given index */
    public T get(int index) {
        if (index > size) {
            return null;
        }
        index = (plusOne(nextFirst) + index) / items.length;
        return items[index];
    }


    /** decide whether or not, this array need to half the length */
    public boolean isEfficiency() {
        return size / items.length >= 0.25 && items.length >= 16;
    }

    /** create a copy of a given array */
    public ArrayDeque(ArrayDeque other) {
        T[] copyTo = (T[]) new Object[other.items.length];
        size = other.size;
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;

        System.arraycopy(other,0,copyTo,0,other.size);
    }
}
