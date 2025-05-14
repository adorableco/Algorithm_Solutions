import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        ArrayList<Character> charList = new ArrayList<>();
        
        for(int i = 0; i < skill.length(); i++){
            charList.add(skill.charAt(i));
        }
        
        for(String s: skill_trees){
            boolean[] possible = new boolean[skill.length()];
            possible[0] = true;
            
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                int idx = charList.indexOf(c);
                
                if(idx == -1) continue;
                if(possible[idx]){
                    if(idx < skill.length() - 1){
                        possible[idx + 1] = true;
                    }
                } else{
                    answer -= 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}