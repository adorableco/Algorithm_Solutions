import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    private ArrayList<Integer> queue = new ArrayList<>();
    private int top = 0;
    private int bottom = 0;
    
    private boolean isEmpty(){
        return (top == bottom);
    }
    
    private void add(int item){
        queue.add(item);
        queue.sort((o1, o2) -> Integer.compare(o1, o2));
    }
    
    private void pop(boolean isMax){
        if(queue.size() == 0) return;
        
        if(isMax){
            queue.remove(queue.size() - 1);
            return;
        }
        queue.remove(0);
    }
    
    public int[] solution(String[] operations) {
        
        for(String operation: operations){
            String[] oper = operation.split(" ");
            if(oper[0].equals("I")){
                add(Integer.parseInt(oper[1]));
            }else{
                if(Integer.parseInt(oper[1]) > 0){
                    pop(true);
                }else pop(false);
            }
        }
        
        if(queue.size() == 0) return new int[]{0, 0};
        return new int[]{queue.get(queue.size() - 1), queue.get(0)};
    }
}