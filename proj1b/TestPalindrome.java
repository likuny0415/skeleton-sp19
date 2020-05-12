import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        // test 1
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);

        // test 2
        Deque d1 = palindrome.wordToDeque("1234");
        String act1 = "";
        for (int j = 0; j < 4; j++) {
            act1 += d1.removeFirst();
        }
        assertEquals("1234", act1);
    }

    @Test
    public void testIsPalindrome() {
        // cat -> not palindrome
        assertFalse(palindrome.isPalindrome("cat"));

        // noon -> palindrome
        assertTrue(palindrome.isPalindrome("noon"));

        // empty case -> palindrome
        assertTrue(palindrome.isPalindrome(""));

        // a -> palindrome
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testIsPalindromeCC() {
        CharacterComparator obo = new OffByOne();

        // empty
        assertTrue(palindrome.isPalindrome("", obo));

        // one element
        assertTrue(palindrome.isPalindrome("a", obo));

        // flake
        assertTrue(palindrome.isPalindrome("flake", obo));

        // following tests from online
        assertTrue(palindrome.isPalindrome("zyzy", obo));
        assertTrue(palindrome.isPalindrome("yyxz", obo));
        assertTrue(palindrome.isPalindrome("yyyxz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
        assertFalse(palindrome.isPalindrome("xyz", obo));
        assertFalse(palindrome.isPalindrome("aa", obo));
    }
}