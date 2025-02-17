import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        
        map.put(1, new HashMap<>());
        
        for(int i = 1; i <= 26; i++){
            map.get(1).put(Character.toString((char) 64 + i), i);
        }
        
        int idx = 0;
        int lastIdx = 27;
        
        while(idx < msg.length()){
            for(int i = msg.length(); i > idx; i--){
                String sub = msg.substring(idx, i);
                if(!map.containsKey(i - idx)) continue;
                HashMap<String, Integer> idxMap = map.get(i - idx);
                
                if(idxMap.containsKey(sub)){
                    answer.add(idxMap.get(sub));
                    if(!map.containsKey(i - idx + 1)) map.put(i - idx + 1, new HashMap<>());
                    HashMap<String, Integer> addMap = map.get(i - idx + 1);
                    if(i < msg.length()) addMap.put(msg.substring(idx, i + 1), lastIdx++);
                    idx = i - 1;
                    break;
                }
            }
            
            idx++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}