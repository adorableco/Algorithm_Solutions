class Solution {
    public int solution(int n) {
        int answer = 1;
        int num = 1;
        
        while (num < n) {
            num++;
            answer++;
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
        }
        return answer;
    }
}