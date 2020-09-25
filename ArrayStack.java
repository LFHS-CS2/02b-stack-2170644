import java.util.EmptyStackException;
/**
 * ArrayStack should implement the Stack interface.
 * You should write your own test cases in ArrayStackTest
 *
 * @author Nikko Kowalow
 */
public class ArrayStack<E> implements Stack<E>
{
    
    Object[] stack;
    public ArrayStack(int size){
      this.stack = new Object[size];    
    }

    int index = -1;

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
      stack[index--] = null;
      return ob;
    }

    /** 
     * Add the given value to the stack. 
     */
    public void push (E ob){
      if(index >= (stack.length - 1)){
          Object[] doubleStack = new Object[stack.length * 2];
          for(int i = 0; i < stack.length; i++){
              doubleStack[i] = stack[i];
          }
          stack = doubleStack;
      } else {
        stack[++index] = ob;
      }
    }
}
