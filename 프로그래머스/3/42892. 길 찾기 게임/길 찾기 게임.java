import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    private static class Node{
        int num, x, y;
        Node left, right;
        
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    private static Node makeBT(int[][] nodeinfo){
        Node[] nodes = new Node[nodeinfo.length];
         for(int i = 0; i < nodes.length; i ++){
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y){
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
            }
        );
        
        Node root = nodes[0];
        
        for(int i = 1; i < nodes.length; i++){
            Node parent = root;
            
            while(true){
                if(nodes[i].x < parent.x){
                    if(parent.left == null){
                        parent.left = nodes[i];
                        break;
                    } else{
                        parent = parent.left;
                    }
                } else{
                    if(parent.right == null){
                        parent.right = nodes[i];
                        break;
                    } else{
                        parent = parent.right;
                    }
                }
            }
        }
        return root;
    }
    
    private void preorder(Node now, ArrayList<Integer> answer){
        if(now == null) return;
        
        answer.add(now.num);
        preorder(now.left, answer);
        preorder(now.right, answer);
    }
    
    private void postorder(Node now, ArrayList<Integer> answer){
        if(now == null) return;
        
        postorder(now.left, answer);
        postorder(now.right, answer);
        answer.add(now.num);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Integer> preorderList = new ArrayList<>();
        ArrayList<Integer> postorderList = new ArrayList<>();
        
        Node root = makeBT(nodeinfo);

        preorder(root, preorderList);
        postorder(root, postorderList);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preorderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postorderList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}