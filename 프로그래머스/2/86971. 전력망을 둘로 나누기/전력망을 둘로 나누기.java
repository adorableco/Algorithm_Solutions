import java.util.ArrayList;
import java.lang.Math;

class Solution {
    private ArrayList<Integer>[] tree;
    private int[] check;
    
    // dont: 끊어낼 엣지
    public int order(Integer now, Integer dont){
        int visited = 0;
        if(tree[now].size() == 0) return 1;
        check[now] = 1;
        
        for(Integer t: tree[now]){
            if(t == dont) continue;
            if(check[t] == 1) continue;
            visited += order(t, dont);
        }
        
        return visited + 1;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        tree = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        
        for(int i = 1; i < tree.length; i++){
            for(Integer t: tree[i]){
                // i 노드와 t 노드 사이의 엣지를 끊어냈을 때 두 트리가 가지는 노드 개수를 first, second에 할당
                check = new int[tree.length];
                int first = order(i, t);
                check = new int[tree.length];
                int second = order(t, i);
                answer = Math.min(Math.abs(first - second), answer);
            }
        }
        
        return answer;
    }
}