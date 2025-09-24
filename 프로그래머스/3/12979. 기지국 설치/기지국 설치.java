import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int coverage = 2 * w + 1;
        int start = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int station : stations) {
            if (station - w - start > 0)
               arr.add(station - w - start); 
            start  = station + w + 1;
        }
        
        if (stations[stations.length - 1] + w < n) arr.add(n - start + 1);
        
       for (int i = 0; i < arr.size(); i++) {
           answer += arr.get(i) / coverage;
           if (arr.get(i) % coverage != 0) answer++;
           
       }
        return answer;
    }
}