import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i: nums){
            set.add(i);
        }
        
        int answer = set.size();
        
        while(answer > nums.length / 2){
            answer -= 1;
        }
        
        return answer;
    }
}