class Solution {
    private static String[] words = new String[] {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab : babbling) {
            if (isPossible(bab)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPossible(String bab){
        int offset = 0;
        boolean[] used = new boolean[4];
        int i = 0;
        
        while (i < words.length) {
            if (offset == bab.length()) return true;
            
            if (!used[i] && bab.startsWith(words[i], offset)) {
                offset += words[i].length();
                used[i] = true;
                i = 0;
            } else i++;
        }
        
        return offset == bab.length();
    }
}