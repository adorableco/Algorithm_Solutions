import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> answer = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], referral[i]);
        }
        
        
        for(int i = 0; i < seller.length; i++){
            String curName = seller[i];
            int money = amount[i] * 100;
            
            while(money > 0 && !curName.equals("-")){
                answer.put(curName, answer.getOrDefault(curName, 0) + money - (money / 10));
                curName = map.get(curName);
                money /= 10;
            }
        }
        
        int[] result = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++){
            result[i] = answer.getOrDefault(enroll[i], 0);
        }
        
        return result;
    }

}