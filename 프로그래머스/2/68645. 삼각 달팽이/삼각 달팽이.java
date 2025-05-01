class Solution {
    private int[] answer;
    private void snail(int startIdx, int startLevel, int height, int startNum){
        int gap = startLevel;
        
        if(height == 1){
            answer[startIdx] = startNum++;
            return;
        }
        
        for(int i = 0; i < height - 1; i++){
            answer[startIdx] = startNum++;
            startIdx += (gap++);
        }


        for(int i = 0; i < height - 1; i++){
            answer[startIdx++] = startNum++;
        }

        for(int i = 0; i < height - 1; i++){
            answer[startIdx] = startNum++;
            startIdx -= (gap--);
        }
        
        if(height > 3){
            snail(startIdx + startLevel / 2 + (startLevel + 1) / 2 * 3 + 1, startLevel + 2, height - 3, startNum);
        }
    }
    
    public int[] solution(int n) {
        answer = new int[n * (n + 1) / 2];
        snail(0, 1, n, 1);
        return answer;
    }
}