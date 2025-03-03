import java.util.ArrayDeque;

class Solution {
    
    public static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        int[][] visited = new int[n][m];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
         for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[0][0] = 1;
        
        queue.addLast(new Node(0, 0));
        
        while(!queue.isEmpty()){
            Node cur = queue.pollFirst();
            
            if(maps[cur.x][cur.y] == 0) continue;
            
            if(cur.y + 1 < m && maps[cur.x][cur.y + 1] == 1 && visited[cur.x][cur.y + 1] == 0){
                dist[cur.x][cur.y + 1] = Math.min(dist[cur.x][cur.y + 1], dist[cur.x][cur.y] + 1);
                queue.addLast(new Node(cur.x, cur.y + 1));
                visited[cur.x][cur.y + 1] = 1;
            }
            if(cur.x + 1 < n && maps[cur.x + 1][cur.y] == 1 && visited[cur.x + 1][cur.y] == 0){
                dist[cur.x + 1][cur.y] = Math.min(dist[cur.x + 1][cur.y], dist[cur.x][cur.y] + 1);
                queue.addLast(new Node(cur.x + 1, cur.y));
                visited[cur.x + 1][cur.y] = 1;
            }
              if(cur.y - 1 >= 0 && maps[cur.x][cur.y - 1] == 1 && visited[cur.x][cur.y - 1] == 0){
                dist[cur.x][cur.y - 1] = Math.min(dist[cur.x][cur.y - 1], dist[cur.x][cur.y] + 1);
                queue.addLast(new Node(cur.x, cur.y - 1));
                  visited[cur.x][cur.y - 1] = 1;
            }
            if(cur.x - 1 >= 0 && maps[cur.x - 1][cur.y] == 1 && visited[cur.x - 1][cur.y] == 0){
                dist[cur.x - 1][cur.y] = Math.min(dist[cur.x - 1][cur.y], dist[cur.x][cur.y] + 1);
                queue.addLast(new Node(cur.x - 1, cur.y));
                visited[cur.x - 1][cur.y] = 1;
            }
        }
           
        if(dist[n - 1][m - 1] == Integer.MAX_VALUE) return -1;
        return dist[n - 1][m - 1];
    }
}