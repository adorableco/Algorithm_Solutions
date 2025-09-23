import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        if (tangerine.length == 1){
            return 1;
        }
        
        Arrays.sort(tangerine);
        
        int cnt = 1;
        for (int i =  1; i < tangerine.length; i++){
            if (tangerine[i] != tangerine[i - 1]) {
                arr.add(cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        
        if (tangerine[tangerine.length - 1] == tangerine[tangerine.length - 2]) {
        arr.add(cnt);
        } else arr.add(1);
        
        int[] cnts = arr.stream().sorted().mapToInt(Integer::intValue).toArray();
        int idx = cnts.length - 1;
                
        while (k > 0 && idx >= 0) {
            k -= cnts[idx];
            answer++;
            idx--;
        }
        return answer;
    }
}