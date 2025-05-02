class Solution {
    private int[][] Arr;
    private int[] answer = new int[2];
    
    private int dfs(int n, int x, int y){
        if(n == 1){
            return Arr[x][y];
        }
        int result = 0;
        int dir[][] = new int[][]{{0, 0}, {n / 2, 0}, {n / 2, n / 2}, {0, n / 2}};
        
        for(int i = 0; i < 4; i++){
            result += dfs(n / 2, x + dir[i][0], y + dir[i][1]);
        }
        
        if(result == 4){
            answer[1] -= 3;
            return 1;
        } else if(result == 0){
            answer[0] -= 3;
            return 0;
        }     
        
        return -4;
    }
    
    public int[] solution(int[][] arr) {
        int length = arr.length;
        
        Arr = new int[length][length];
            
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                Arr[i][j] = arr[i][j];
                if(arr[i][j] == 0) answer[0] += 1;
                else answer[1] += 1;
            }
        }
        dfs(Arr.length, 0, 0);
        return answer;
    }
}