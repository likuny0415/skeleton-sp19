public class OffByN implements CharacterComparator {
    private int offset;

    // constructor
    public OffByN(int x) {
        offset = x;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return y - x == offset || y - x == -offset;
    }
}
