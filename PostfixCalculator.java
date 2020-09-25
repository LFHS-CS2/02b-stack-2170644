/**
Postfix calculator
@author Nikko Kowalow
9/24/20
**/

import java.util.EmptyStackException;

class PostfixCalculator {
  
  char[] operators = {'+', '-', '*', '/', '^'};
  final int SPACE = 32;

  /*
    evaluate calculates a given String expression. If the expression is invalid, it will throw a PostfixError. Otherwise, it will go through each character in the expression and utilise a stack to calculate the final result. If the current character is an operator, it will pop the top two digits from the stack and perform the operator on those two digits, pushing the result back into the stack. It does this until the final result is the only thing left in the stack, which is later returned.
  */
  public int evaluate(String expression) throws PostfixError {
    ArrayStack<Integer> postfix = new ArrayStack(100);
    if(!isValidExpression(expression)){
      throw new PostfixError("Check your postfix expression and try again. Make sure to only have digits and valid operators (+ - * / ^)");
    }
    try {
        for (int i = 0; i < expression.length(); i++) {
          char current = expression.charAt(i);
          if (Character.isDigit(current)) {
            postfix.push(Integer.parseInt(String.valueOf(current)));
          } else if(isOperator(current)){
            int num2 = 0;
            int num1 = 0;
            try {
              num2 = postfix.pop();
              num1 = postfix.pop(); 
            } catch (EmptyStackException e) {
              System.out.println("Incorrect order or too little/many operators and/or numbers.");
            }
            int result = 0;
            if(current == '+') {
              result = num1 + num2;
            } else if(current == '-'){
              result = num1 - num2;
            } else if(current == '*'){
              result = num1 * num2;
            } else if(current == '/'){
              result = num1 / num2;
            } else {
              result = (int)Math.pow(num1, num2);
            }
            postfix.push(result);
          } 
        } 
    } 
    catch (PostfixError e) {
        System.out.println("Something went wrong.");
    }

    return postfix.peekTop();
  }
  
  /*
    isValidExpression checks whether or not the given expression is valid by looping through it and checking if each character is either a digit, operator, or space.
  */
  public boolean isValidExpression(String expression) {
    for(int i = 0; i < expression.length(); i++){
      char current = expression.charAt(i);
      if(!isOperator(current) && !Character.isDigit(current) && current != SPACE){
        return false;
      }
    }
    return true;
  }

  /*
    toString takes the entire given expression and returns it alongside the result. 
  */
  public String toString(String expression) {
    int result = evaluate(expression);
    return expression + " = " + result;
  }  

  /*
    isOperator checks whether or not the current character in the given expression in either the evaluate method or toString method is in fact a valid operator(+ - * / ^). It simply just loops through an array of valid operators and checks if the character is equal to at least one value from that array.
  */
  public boolean isOperator(char current) {
    for(char ch : operators){
      if(current == ch){
        return true;
      }
    }
    return false;
  }
}
