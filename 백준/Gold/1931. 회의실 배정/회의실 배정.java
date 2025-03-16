import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Time[] times;

    private static class Time{
        int start, end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static public int solution(int startIdx, int total) {
        if(startIdx + 1 >= times.length) return total;

        int i = startIdx + 1;
        while(i < times.length && times[startIdx].end > times[i].start) i++;

        if(i == times.length) return total;
        
        return solution(i, total + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        times = new Time[n];

        for(int i = 0; i < n; i++){
            times[i] = new Time(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(times, (o1, o2) -> {
            if(o1.end == o2.end) return o1.start - o2.start;
            return o1.end - o2.end;
        });

        System.out.println(solution(0, 1));
    }
}
