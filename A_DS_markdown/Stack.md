### 20. Valid Parentheses
*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.*

*The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*
- 简单，看代码
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            }else if(s.charAt(i) == '{'){
                stack.push('}');
            }else if(s.charAt(i) == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty() == true){
                    return false;
                }else {
                    if(stack.pop() != s.charAt(i)){
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty() == false)
            return false;
        return true;
    }
}
```
