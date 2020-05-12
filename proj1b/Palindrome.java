public class Palindrome {

    /** given a string, and change it into deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /**  check whether it is a palindrome */
    public boolean isPalindrome(String word) {
        Deque<Character> d1 = wordToDeque(word);
        return isPalindrome(d1);
    }

    /** isPalindrome helper */
    private boolean isPalindrome(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            return d.removeFirst() == d.removeLast() &&
                    isPalindrome(d);
        }
    }

    /** overload isPalindrome
     * check whether the given string is a palindrome
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome(d, cc);
    }

    /** overload isPalindrome helper */
    private boolean isPalindrome(Deque<Character> d, CharacterComparator cc) {
       if (d.size() == 0 || d.size() == 1) {
           return true;
       }
       else {
           return cc.equalChars(d.removeFirst(),d.removeLast()) &&
                   isPalindrome(d, cc);
       }
    }
}
