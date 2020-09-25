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
    test.test_postfix();
  }

    /**
     * This is an example test.  After you have written your own tests,
     * get rid of it.
     */
    @Test
    public void test_example() {
        ArrayStack stack = new ArrayStack(100);
        assertTrue("Stack should be empty", stack.isEmpty());
        stack.push(1);
        assertTrue("Stack should not be empty", !stack.isEmpty());
        assertEquals("Peek should equal 1", stack.peekTop(), 1);
        assertEquals("Pop should equal 1", stack.pop(), 1);
        assertTrue("Stack should be empty", stack.isEmpty());
        
        for(int i = 0; i < 200; i++){
          stack.push(i + 1);
        }
        while(!stack.isEmpty()){
          stack.pop();
        }
        assertTrue("Stack should be empty", stack.isEmpty());

        List<Object> list = new ArrayList<Object>();
        while(!stack.isEmpty()){
          list.add(stack.pop());
        }
        // System.out.println(list);
    }

    /**
      test_postfix simply tests all of the cases where the postfixcalculator should either crash or output the wrong answer. It basically just tests all of the main methods such as evaluate, toString, etc.
    **/
    public void test_postfix() {
        PostfixCalculator postfix = new PostfixCalculator();
        assertEquals("Should evaluate to 10", postfix.evaluate("82+"), 10);
        assertEquals("Should equal to 82+ = 10", postfix.toString("82+"), "82+ = 10");
        assertEquals("Should evaluate to 48", postfix.evaluate("92^88*+388/*/"), 48);
        assertEquals("Should evaluate to 8", postfix.evaluate("23^"), 8);
        assertEquals("Should evaluate to -1", postfix.evaluate("56-"), -1);
        assertEquals("Should evaluate to 2", postfix.evaluate("52/"), 2);
        assertTrue("52/8* should be valid", postfix.isValidExpression("52/8*"));
        assertTrue("56/2**58jvdi2?/ should be invalid", !postfix.isValidExpression("56/2**58jvdi2?/"));
        for(char operator : postfix.operators){
          assertTrue(postfix.isOperator(operator));
        }
        assertTrue(!postfix.isOperator('6'));
        
        // if the order of the expression is incorrect, or there is an incorrect amount of numbers and/or operators, 
        // an EmptytackException shuold be thrown in evaluate. 
        boolean exceptionThrown = false;
        try {
          postfix.evaluate("5***");
        } catch (EmptyStackException e) {
          exceptionThrown = true;
          assertTrue("Exception should have been thrown", exceptionThrown);
          //testing to see if my exceptions are thrown when they are supposed to.
        }
    }


}
