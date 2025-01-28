import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        
        while(i < n){
            if(stack.isEmpty() || stack.peek() != s.charAt(i)) stack.push(s.charAt(i));
            else stack.pop();
            
            i++;
        }
        
        if (stack.isEmpty()) return 1;
        return 0;
    }
}