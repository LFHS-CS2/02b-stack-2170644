import java.util.EmptyStackException;

/**
 * ArrayStack should implement the Stack interface.
 * You should write your own test cases in ArrayStackTest
 *
 * @author (your name)
 */
public class ArrayStack<E> implements Stack<E>
{
    Object[] stack = new Object[100];
    int index = -1;
    int size = stack.length;

    public boolean isEmpty(){
      return index == -1;
    }

    /** 
     * Return the value that pop would give, without modifying
     * the stack. TODO:  Throw a StackException if the stack is empty. 
     */
    public E peekTop(){
      if(this.isEmpty()){
        throw new EmptyStackException();
      } else {
        return (E)stack[index];
      }
    }

    /** 
     * Remove and return the value that has been in the stack the
     * least time. TODO: Throw a StackException if the stack is empty. 
     */
    public E pop(){
      if(this.isEmpty()){
        throw new EmptyStackException();
      } 
      E ob = (E)stack[index];
      stack[index] = null;
      index--;
      return ob;
    }

    /** 
     * Add the given value to the stack. 
     */
    public void push (E ob){
      if(index >= (size - 1)){
       System.out.println("Stack is full"); 
      } else {
        stack[index] = ob;
        index++; 
      }
    }
}
