import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int leftA = 0;
        int rightA = A.length - 1;
        int leftB = 0;
        int rightB = rightA;
        
        while(leftA <= rightA && leftB <= rightB){
            // A 최소값 * B 최대값
            int minMax = A[leftA] * B[rightB];
            // A 최대값 * B 최소값
            int maxMin = B[leftB] * A[rightA];
            
            if(maxMin < minMax){
                rightA--;
                leftB++;
                answer += maxMin;
            }else {
                rightB--;
                leftA++;
                answer += minMax;
            }       
        }      
        return answer;
    }
}