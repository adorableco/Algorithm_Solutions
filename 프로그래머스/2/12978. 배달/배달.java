import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.lang.Math;

class Solution {
    
    private static class Node {
        int num;
        int cost;
        
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N + 1];
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int i = 1; i < N + 1; i++){
            adjList[i] = new ArrayList<Node>();
        }
        
        for(int[] r: road){
            adjList[r[0]].add(new Node(r[1], r[2]));
            adjList[r[1]].add(new Node(r[0], r[2]));
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(Node node: adjList[now]){
                if(dist[now] + node.cost < dist[node.num]){
                    dist[node.num] = dist[now] + node.cost;
                    queue.add(node.num);            
                }
            }          
        }
        
        int answer = 0;
        
        for(int i = 1; i < dist.length; i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}