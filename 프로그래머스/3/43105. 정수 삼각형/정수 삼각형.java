import java.lang.Math;

class Solution {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        int w = triangle[h - 1].length;
        int[][] dp = new int[h][w];
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < h; i++){
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            
            for(int j = 1; j < triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
            
        }
        
        int answer = 0;
        for(int i = 0; i < dp[w - 1].length; i++){
            answer = Math.max(answer, dp[w - 1][i]);
        }
        return answer;
    }
}