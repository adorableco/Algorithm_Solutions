import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    int[] xDist = new int[]{0, 0, 1, -1};
    int[] yDist = new int[]{1, -1, 0, 0};
    char[][] map;
    
    private static class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private int bfs(Node start, Node end){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[][] dist = new int[map.length][map[0].length];
        dist[start.x][start.y] = 1;
        queue.add(start);
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.x == end.x && cur.y == end.y){
                return dist[cur.x][cur.y] - 1;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + xDist[i];
                int nextY = cur.y + yDist[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length)
                    continue;
                
                if(map[nextX][nextY] == 'X') continue;
                
                if(dist[nextX][nextY] > 0) continue;
                
                queue.add(new Node(nextX, nextY));
                dist[nextX][nextY] = dist[cur.x][cur.y] + 1;
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        Node startNode = null;
        Node endNode = null;
        Node leverNode = null;
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j  < map[0].length; j++){
                if(map[i][j] == 'S') startNode = new Node(i, j);
                else if(map[i][j] == 'L') leverNode = new Node(i, j);
                else if(map[i][j] == 'E') endNode = new Node(i, j);
            }
        }
        
        int lever = bfs(startNode, leverNode);
        int end = bfs(leverNode, endNode);
            
        if(lever == -1 || end == -1) return -1;
        
        return lever + end;
    }
}