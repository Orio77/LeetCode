import java.util.HashMap;
import java.util.Stack;

class ValidParentheses {

    // My Solution - doesn't work for "({{{{}}}))"
    public boolean myIsValid(String s) {
        if (s == null || s.length() == 1) 
            return false;
        
        Stack<Character> chars = new Stack<>();
        char[] charArray = s.toCharArray();
        int i = 0;
        for (i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[') {
                chars.push(charArray[i]);
            }
            else {
                if (chars.isEmpty()) {
                    return false;
                }

                char previous = charArray[i-1];
                switch (previous) {
                    case '[':
                        if (charArray[i] != ']') 
                            return false;
                        else break;
                    case '(':
                        if (charArray[i] != ')') 
                            return false;
                        else break;
                    case '{':
                        if (charArray[i] != '}') 
                            return false;
                        else break;
                    default:
                        break;
                }

                chars.pop();
            }
        }
        return (chars.isEmpty());
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (Character c : chars) {
            if (map.containsKey(c) && !charStack.isEmpty()) {
                if (map.get(c) == charStack.peek()) {
                    charStack.pop();
                }
                else return false;
            }
            else charStack.push(c);
        }
        return charStack.isEmpty();
    }
}