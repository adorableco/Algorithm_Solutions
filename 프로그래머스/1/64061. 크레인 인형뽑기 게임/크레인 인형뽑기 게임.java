import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board[0].length;
            
        int[] position = new int[n];
        Arrays.fill(position, n);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 0 && position[j] == n) position[j] = i;
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int move: moves){
            if(position[move - 1] == n) continue;
            
            if(!stack.isEmpty() && stack.peek() == board[position[move - 1]][move - 1]){
                stack.pop();        
                answer += 2;
            } else{
                stack.push(board[position[move - 1]][move - 1]);
            }
            position[move - 1] += 1;
        }
        
        return answer;
    }
}