// Author: Chase Blodgett

public class BraceChecker{

/* This function below takes in code in the form of a string and checks the braces in the code
* to see if they allign correctly. Does this with the ADT generic stack. Returns false if the
* braces don't allign correctly and true if they do.
*/
  public static boolean checkBraces(String code){
    GenericStack<Character> codeChar = new GenericStack<>(1000);

    for(int i = 0; i < code.length(); i++){
      if(code.charAt(i) == '{' || code.charAt(i) == '(' || code.charAt(i) == '['){
        codeChar.push(code.charAt(i));
      }
      else if(code.charAt(i) == '}' || code.charAt(i) == ')' || code.charAt(i) == ']'){
        if(codeChar.isEmpty()){
          return false;
        }else if(code.charAt(i) == '}' && codeChar.peek() != '{'){
          return false;
        }else if(code.charAt(i) == ')' && codeChar.peek() != '('){
          return false;
        }else if(code.charAt(i) == ']' && codeChar.peek() != '['){
          return false;
        }else if(code.charAt(i) == '}' && codeChar.peek() == '{'){
          codeChar.pop();
        }else if(code.charAt(i) == ')' && codeChar.peek() == '('){
          codeChar.pop();
        }else if(code.charAt(i) == ']' && codeChar.peek() == '['){
          codeChar.pop();
        }
      }
    }
    if(codeChar.isEmpty()){
      return true;
    }
    else{
      return false;
    }
  }
}
