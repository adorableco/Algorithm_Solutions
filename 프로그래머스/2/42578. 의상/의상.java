import java.util.HashMap;

class Solution {
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        return map.values().stream()
            .reduce(1, (acc, value) -> acc * (value + 1)) - 1;
    }
}