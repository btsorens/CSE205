// Assignment #: 11
// Name: Brock Sorenson
// StudentID: 1220958154
// Description: Checker class is a utility class and is not instantiated.
// It has one method that checks a string to ensure all parentheses, brackets, and braces are matched.
// The method returns an appropriate string detailing whether all are matched or the location of the unmatched.

import java.util.Objects;
import java.util.Stack;

public class Checker{
    public static String check(String lineToCheck){ //checks string for matched () [] and {}

        Stack<String> myStack = new Stack<>(); //instantiate the stack
        String[] stringArray = lineToCheck.split(""); //pareses string into individual characters

        for(int index = 0; index < stringArray.length; index++){ //for loop to analyze each character

            if(myStack.isEmpty()) { //if stack is empty, check for closing brackets that don't match
                if (Objects.equals(stringArray[index], ")"))
                    return ") at the position " + index + " does not match.";
                if (Objects.equals(stringArray[index],"]"))
                    return "] at the position " + index + " does not match.";
                if (Objects.equals(stringArray[index],"}"))
                    return "} at the position " + index + " does not match.";
            }

            if(Objects.equals(stringArray[index], "(")){ //push A for "("
                myStack.push("A");
            }

            if(!myStack.isEmpty()) { //pop A if ")" found
                if (Objects.equals(stringArray[index], ")")) {
                    if (!Objects.equals(myStack.peek(), "A")) {
                        return ") at the position " + index + " does not match.";
                    }
                    myStack.pop();
                }
            }

            if(Objects.equals(stringArray[index], "[")){ //push B for "["
                myStack.push("B");
            }

            if(!myStack.isEmpty()) { //pop B if "]" found
                if (Objects.equals(stringArray[index], "]")) {
                    if (!Objects.equals(myStack.peek(), "B")) {
                        return "] at the position " + index + " does not match.";
                    }
                    myStack.pop();
                }
            }

            if(Objects.equals(stringArray[index], "{")){ //push C for "{"
                myStack.push("C");
            }

            if(!myStack.isEmpty()) { //pop B if "}" is found
                if (Objects.equals(stringArray[index], "}")) {
                    if (!Objects.equals(myStack.peek(), "C")) {
                        return "} at the position " + index + " does not match.";
                    }
                    myStack.pop();
                }
            }
        }//end for loop

        if(!myStack.isEmpty()) { //if stack is not empty detect unmatched opening "(", "[", or "{"
            String token = myStack.peek();
            if (Objects.equals(token, "A"))
                return ") is missing.";
            if (Objects.equals(token, "B"))
                return "] is missing.";
            if (Objects.equals(token, "C"))
                return "} is missing.";
        }

        return "Everything is matched!"; //else return "Everything is matched"


    }//end check
}//end Checker class
