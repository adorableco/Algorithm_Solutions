import java.util.Stack;
import java.util.Map;

class Solution {
    private Stack<String> stack = new Stack<>();
    private Map<Integer, String> map = Map.of(
        10, "A",
        11, "B",
        12, "C",
        13, "D",
        14, "E",
        15, "F"
    );
    
    //10진법 숫자를 n진법 숫자로 변환하여 stack에 push
    private void change(int n, int val){
        while(val >= n){
            int remain = val % n;
            stack.push(map.getOrDefault(remain, Integer.toString(remain)));
            val /= n;
        }
        
        stack.push(map.getOrDefault(val, Integer.toString(val)));
    }
    
    public String solution(int n, int t, int m, int p) {
        int maxNum = m * (t - 1) + p + 1;
        String[] nums = new String[maxNum];
        StringBuilder str = new StringBuilder();
        
        int idx = 0;
        //0~n 까지는 n진법 숫자와 10진법 숫자가 동일하므로 분리하여 처리함
        for(int i = 0; i < n; i++){
            String result = map.getOrDefault(i, Integer.toString(i));
            
            for(int j = 0; j < result.length(); j++){
                nums[idx] = Character.toString(result.charAt(j));
                idx++;
            }
        }
        
        int now = n;
        while(idx < maxNum){
            change(n, now);
            
            // stack에서 pop 하는 순서대로 n진법 숫자가 됨
            while(!stack.isEmpty() && idx < maxNum){
                nums[idx] = stack.pop();
                idx++;
            }
            now++;
        }
        
        for(int i = p - 1; str.length() < t; i += m){
            str.append(nums[i]);
        }
        
        return str.toString();
    }
}