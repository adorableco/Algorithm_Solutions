class Solution {
    private int[] dp;
    
    private int fib(int n){
        if(n <= 1) return n;
        
        if(dp[n - 1] == 0) {
            dp[n - 1] = fib(n - 1);
        }
        if(dp[n - 2] == 0) {
            dp[n - 2] = fib(n - 2);
        }
        
        return (dp[n - 1] + dp[n - 2]) % 1234567;
    }
    
    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        
        int answer = fib(n);
        
        return answer % 1234567;
    }
}