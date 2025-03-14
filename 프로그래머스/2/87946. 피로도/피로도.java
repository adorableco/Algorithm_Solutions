import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    boolean[] completed;
    int[][] Dungeon;
    
    private int findNext(int remain){
        int answer = 0;
        for(int i = 0; i < Dungeon.length; i++){
            if(completed[i] == true) continue;
            
            if(Dungeon[i][0] <= remain){
                completed[i] = true;
                int result = findNext(remain - Dungeon[i][1]);
                completed[i] = false;
                answer = result + 1 > answer? result + 1: answer;
            }
        }
        return answer;
    }
    
    public int solution(int k, int[][] dungeons) {
        Dungeon = dungeons;
        completed = new boolean[dungeons.length];
        
        int answer = findNext(k);
        return answer;
    }
}