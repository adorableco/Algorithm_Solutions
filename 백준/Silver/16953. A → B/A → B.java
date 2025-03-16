import java.util.Scanner;

public class Main {

    static public int solution(int a, int b) {
        int answer = 0;

        while(a != b){
            if(b % 2 == 1 && b % 10 != 1) return -1;
            if(a > b) return -1;

            if(b % 2 == 1){
                b = (b - 1) / 10;
            }else{
                b /= 2;
            }
            answer++;
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(solution(a, b));
    }
}
