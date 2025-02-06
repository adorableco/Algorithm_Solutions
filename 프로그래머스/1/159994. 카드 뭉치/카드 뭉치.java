import java.util.ArrayDeque;

class Solution {
    
    private ArrayDeque<String> queue1 = new ArrayDeque<>();
    private ArrayDeque<String> queue2 = new ArrayDeque<>();
    
    private void initDeque(ArrayDeque<String> deque, String[] cards){
        for(String card: cards){
            deque.add(card);
        }
    }
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        initDeque(queue1, cards1);
        initDeque(queue2, cards2);
        
        String answer = "Yes";
        
        for(int i = 0; i < goal.length; i++){
            if(!queue1.isEmpty() && queue1.getFirst().equals(goal[i])){
                queue1.pollFirst();
            } else if(!queue2.isEmpty() && queue2.getFirst().equals(goal[i])){
                queue2.pollFirst();
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}