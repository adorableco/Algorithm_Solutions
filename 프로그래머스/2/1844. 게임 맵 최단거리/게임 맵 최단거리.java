import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private class Node {
        int x, y;
        
        public Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] answer = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for(int[] ans : answer){
            Arrays.fill(ans, Integer.MAX_VALUE);
        }
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(0 , 0));
        answer[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dirs[i][0];
                int nextY = now.y + dirs[i][1];
                
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                
                if (maps[nextX][nextY] == 0 || visited[nextX][nextY])
                    continue;
                
                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY));
                
                if (answer[nextX][nextY] > answer[now.x][now.y] + 1){
                    answer[nextX][nextY] = answer[now.x][now.y] + 1;
                }
            }
        }
        
        return visited[n - 1][m - 1] ? answer[n - 1][m - 1] : -1;
    }
}