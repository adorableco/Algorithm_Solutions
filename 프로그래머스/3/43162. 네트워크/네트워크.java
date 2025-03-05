class Solution {
    private static int[][] computer;
    private static boolean[] visited;
    
    private static void dfs(int now){
        for(int i = 0; i < computer[now].length; i++){
            if(computer[now][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(i);                
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        computer = computers;
        
        for(int i = 0; i < n; i ++){
            if(visited[i] == true) continue;
            dfs(i);
            answer++;
        }
        return answer;
    }
}