public interface Deque<Item> {

    void addFirst(Item t);
    void addLast(Item t);
    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
    default boolean isEmpty() {
        return size() == 0;
    }
}
