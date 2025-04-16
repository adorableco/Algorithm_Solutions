import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, State> stateMap = new HashMap<>();

    private static class State {
        int nextZero;
        int nextOne;
        boolean isTerminal;

        public State(int nextZero, int nextOne, boolean isTerminal) {
            this.nextZero = nextZero;
            this.nextOne = nextOne;
            this.isTerminal = isTerminal;
        }
    }

    private static void initState(){
        stateMap.put(1, new State(7,2, false));
        stateMap.put(2, new State(3,-1, false));
        stateMap.put(3, new State(4,-1, false));
        stateMap.put(4, new State(4,5, false));
        stateMap.put(5, new State(7,6, true));
        stateMap.put(6, new State(9,6, true));
        stateMap.put(7, new State(-1,8, false));
        stateMap.put(8, new State(7,2, true));
        stateMap.put(9, new State(4,10, false));
        stateMap.put(10, new State(7,2, true));
    }

    private static String solution(String string){
        int curState = 1;

        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            int parsedInt = Integer.parseInt(String.valueOf(c));

            if (parsedInt == 0){
                curState = stateMap.get(curState).nextZero;
            } else {
                curState = stateMap.get(curState).nextOne;
            }

            if(curState == -1) return "NOISE";
        }

        if (stateMap.get(curState).isTerminal){
            return "SUBMARINE";
        }
        return "NOISE";
    }

    public static void main(String[] args) {
        initState();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(solution(string));
    }
}
