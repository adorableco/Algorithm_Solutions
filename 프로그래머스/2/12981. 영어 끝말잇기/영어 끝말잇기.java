import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        HashSet<String> set = new HashSet<>();
    
        
        int person  = 0;
        
        String prevWord = null;
        
        for(String word: words){
            if(prevWord != null){
                if(prevWord.charAt(prevWord.length() - 1) != word.charAt(0)){
                    return new int[]{(person % n) + 1, person / n + 1};
                }
            }
            int beforeSize = set.size();
            set.add(word);
            int afterSize = set.size();
            
            if(beforeSize == afterSize){
                return new int[]{(person % n) + 1, person / n + 1};
            }
            person += 1;
            prevWord = word;
        }

        return new int[]{0,0};
    }
}