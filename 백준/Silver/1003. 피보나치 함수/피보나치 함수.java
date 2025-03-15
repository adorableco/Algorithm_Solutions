import java.util.Scanner;

public class Main {
    private static int[][] dp;

    static public int[] solution(int fib) {
        if(dp[fib][0] >= 0) {
            return dp[fib];
        }

        int[] solution1 = solution(fib - 1);
        int[] solution2 = solution(fib - 2);
        dp[fib][0] = solution1[0] + solution2[0];
        dp[fib][1] = solution1[1] + solution2[1];
        dp[fib][2] = solution1[2] + solution2[2];
        return dp[fib];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new int[41][3];
        for(int i = 2; i <= 40; i++) {
            dp[i][0] = -1;
        }
        dp[0][0] = 0;
        dp[1][0] = 1;
        dp[0][1] = 1;
        dp[1][2] = 1;

        for(int i = 1; i <= n; i++) {
            int num = scanner.nextInt();
            int[] solution = solution(num);
            System.out.println(solution[1] + " " + solution[2]);
        }
    }
}
