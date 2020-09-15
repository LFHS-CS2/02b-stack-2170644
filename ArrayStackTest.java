import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * Tests ArrayStack
 *
 */
public class ArrayStackTest
{
  public static void main(String args[]) {
    ArrayStackTest test = new ArrayStackTest();
    test.test_example();
  }

    /**
     * This is an example test.  After you have written your own tests,
     * get rid of it.
     */
    @Test
    public void test_example() {
      //  ArrayStack stack = new ArrayStack();
          ArrayStack stack = new ArrayStack();
          assertTrue("Stack should be empty", stack.isEmpty());
          stack.push(1);
          assertTrue("Stack should not be empty", !stack.isEmpty());
          assertEquals("Peek should equal 1", stack.peekTop(), 1);
          assertEquals("Pop should equal 1", stack.pop(), 1);
          assertTrue("Stack should be empty", stack.isEmpty());

          for(int i = 0; i < 100; i++){
            stack.push(i);
          }
        
        // assertEquals("they should be equal", 5, 5);
        // // when comparing doubles, the last number is a threshold
        // //   of how close the numbers should be to be considered equal
        // assertEquals("they should be with .01 of each other", 5.12, 5.11, .01);
        // if (false)
        //     fail("It should have been true");
    }

}
