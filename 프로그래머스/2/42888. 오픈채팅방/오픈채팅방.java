import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String r: record){
            String[] cmd = r.split(" ");
            if(cmd.length == 3) map.put(cmd[1], cmd[2]);
        }
        
        for(int i = 0; i < record.length; i++){
            String[] cmd = record[i].split(" ");
            
            if(cmd[0].equals("Enter")){
                answer.add(map.get(cmd[1]) + "님이 들어왔습니다.");
            } else if(cmd[0].equals("Leave")){
                answer.add(map.get(cmd[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}