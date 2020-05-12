import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        // a & b
        boolean out1 = offByOne.equalChars('a', 'b');
        Assert.assertTrue(out1);

        // r & q
        boolean out2 = offByOne.equalChars('r', 'q');
        Assert.assertTrue(out2);

        // & and %
        boolean out5 = offByOne.equalChars('&', '%');
        Assert.assertTrue(out5);

        // a & e -> false
        boolean out3 = offByOne.equalChars('a', 'e');
        Assert.assertFalse(out3);

        // a & a -> false
        boolean out4 = offByOne.equalChars('a', 'a');
        Assert.assertFalse(out4);


    }

}
