class Solution {
    public int[] solution(int brown, int yellow) {
        int now = brown + yellow;
        int n = brown + yellow;
        int prev = 0;
        
        while(now > 0 && now > prev){
            now -= 1;
            if(n % now != 0) continue;
            
            prev = n / now;
            
            if(brown == 2 * (now + prev) - 4 &&  yellow == n - brown){
                return new int[]{now, prev};
            }
        }
        return new int[]{now, prev};
    }
}