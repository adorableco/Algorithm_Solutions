import java.lang.Math;

class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++){
            dp[0][i] = board[0][i];
        }
        
        for(int i = 1; i < n; i++){
            dp[i][0] = board[i][0];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(board[i][j] == 1 && dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0){
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = board[i][j];
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer * answer;
    }
}