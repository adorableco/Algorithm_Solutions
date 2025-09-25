import java.lang.Math;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[3];
        int idx = -1;
        
        String[] darts = dartResult.split("");
        
        for (int i = 0; i < darts.length; i++) {
            if (darts[i].equals("D")) {
                scores[idx] = (int) Math.pow(scores[idx], 2);
            } else if (darts[i].equals("T")) {
                scores[idx] = (int) Math.pow(scores[idx], 3);
            } else if (darts[i].equals("*")) {
                if (idx > 0) scores[idx - 1] *= 2;
                scores[idx] *= 2;
            } else if (darts[i].equals("#")) {
                scores[idx] *= -1;
            } else if (!darts[i].equals("S")) {
                if (darts[i].equals("1") && i < darts.length - 1 && darts[i + 1].equals("0")) {
                    scores[++idx] = 10;
                    i++;
                    continue;
                }
                int s = Integer.parseInt(darts[i]);
                scores[++idx] = s;
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}