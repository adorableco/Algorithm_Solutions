import java.lang.Math;

class Solution {
    boolean[][] boards;
    
    private boolean check(int row, int col, int n){
        for(int i = 0; i < n; i++){
            if(i == col) continue;
            if(boards[row][i] == true) return false; 
        }
        
        for(int i = 0; i < n; i++){
            if(i == row) continue;
            if(boards[i][col] == true) return false; 
        }
        
        for(int i = 0; i < n; i++){
            if(i == row) continue;

            int diff = Math.abs(i - row);

            if(col - diff >= 0 && boards[i][col - diff] == true) return false;
            if(col + diff < n && boards[i][col + diff] == true) return false;
        }
        return true;
    }
    
    private int findPlace(int row, int n){
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(check(row, i, n)) {
                if(row == n - 1) answer += 1;
                if(row + 1 >= n) continue;
                boards[row][i] = true;
                
                int result = findPlace(row + 1, n);
                boards[row][i] = false;
                answer += result;
                
            }
        }
        return answer;
    }
    
    public int solution(int n) {
        boards = new boolean[n][n];
        int answer = 0;
        return findPlace(0,n);
    }
}