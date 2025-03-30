import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
        String[] spl = s.split("\\{|\\}", 0);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String sp: spl){
            if(sp.length() <= 0) continue;
            String[] temp = sp.split(",");
            
            ArrayList<Integer> tup = new ArrayList<>();
            
            for(String t: temp){
                tup.add(Integer.parseInt(t));
            }
            
            list.add(tup);
        }
        
        list.sort(Comparator.comparingInt(ArrayList::size));
        
        for(int i = 0; i < list.size(); i++){
            ArrayList<Integer> li = list.get(i);
            for(int j = 0; j < li.size(); j++){
                if(answer.contains(li.get(j))) continue;
                
                answer.add(li.get(j));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}