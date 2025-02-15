import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> idMap = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            idMap.put(id_list[i], i);
        }
        
        for(String r: report){
            String[] spr = r.split(" ");
            
            if(!map.containsKey(spr[1])){
                map.put(spr[1], new ArrayList<>());
            }
            ArrayList<String> users = map.get(spr[1]);
            if(!users.contains(spr[0])) users.add(spr[0]);
        }
        
        for(HashMap.Entry<String, ArrayList<String>> entry: map.entrySet()){
             if(entry.getValue().size() >= k) {
                 for(String string: entry.getValue()){
                     answer[idMap.get(string)] += 1;
                 }
             }
        }
        return answer;
    }
}