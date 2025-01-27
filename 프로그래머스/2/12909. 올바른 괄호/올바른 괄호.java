import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sList = s.toCharArray();
        
        for(int i = 0; i < sList.length; i++){
            if(sList[i] == '(') {
                stack.push(sList[i]);
            } else if (stack.isEmpty() == true || stack.pop() != '('){
                return false;
            }
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
}