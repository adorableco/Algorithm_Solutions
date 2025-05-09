class Solution {
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int solution(int[] arr) {
        int n = arr.length;
        if(arr.length == 1) return arr[0];
        
        int gcf = gcd(arr[0],arr[1]);
        int answer = arr[0] * arr[1] / gcf;
        
        for(int i = 2; i < arr.length ; i++){
            if(answer < arr[i]) gcf = gcd(answer, arr[i]);
            else gcf = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcf;
        }
        return answer;
    }
}