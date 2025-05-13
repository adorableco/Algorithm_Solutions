import java.lang.StringBuilder;
import java.util.ArrayList;
import java.lang.Math;

class Solution {
    private long find(ArrayList<Long> operands, ArrayList<Character> operators, char[] top){
         int topIdx = 0;
        
         while(!operators.isEmpty()){
            int idx = operators.indexOf(top[topIdx]);
            if(idx == -1){
                topIdx++;
                continue;
            }
            
            operators.remove(idx);
            long left = operands.remove(idx);
            long right = operands.remove(idx);
            
            if(top[topIdx] == '*'){
                operands.add(idx, left * right);
            }else if(top[topIdx] == '-'){
                operands.add(idx, left - right);
            }else {
                operands.add(idx, left + right);
            }
            
        }
        return operands.get(0);
    }
    
    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> operands = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        
        for(int i = 0; i < expression.length();){
            StringBuilder sb = new StringBuilder();
            int j = i;
            while(j < i + 3 && j < expression.length()){
                if(Character.isDigit(expression.charAt(j))){
                    sb.append(expression.charAt(j));
                } else break;
                j++;
            }
            i = j;
            operands.add(Long.parseLong(sb.toString()));
            
            if(i < expression.length()){
               operators.add(expression.charAt(i));
               i++;
            }
        }
        
        long find = Math.abs(find((ArrayList<Long>) operands.clone(),(ArrayList<Character>) operators.clone(), new char[]{'*', '+', '-'}));
        if(answer < find){
            answer = find;
        }
        find = Math.abs(find((ArrayList<Long>) operands.clone(), (ArrayList<Character>) operators.clone(), new char[]{'*', '-', '+'}));
        if(answer < find){
            answer = find;
        }
        find = Math.abs(find((ArrayList<Long>) operands.clone(), (ArrayList<Character>) operators.clone(), new char[]{'-', '*', '+'}));
        if(answer < find){
            answer = find;
        }
        find = Math.abs(find((ArrayList<Long>) operands.clone(), (ArrayList<Character>) operators.clone(), new char[]{'-', '+', '*'}));
        if(answer < find){
            answer = find;
        }
        find = Math.abs(find((ArrayList<Long>) operands.clone(), (ArrayList<Character>) operators.clone(), new char[]{'+', '-', '*'}));
        if(answer < find){
            answer = find;
        }
        find = Math.abs(find((ArrayList<Long>) operands.clone(), (ArrayList<Character>) operators.clone(), new char[]{'+', '*', '-'}));
        if(answer < find){
            answer = find;
        }
        
       return answer;
    }
}