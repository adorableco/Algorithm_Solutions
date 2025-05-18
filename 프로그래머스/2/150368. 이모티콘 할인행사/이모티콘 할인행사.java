import java.util.Arrays;

class Solution {
    private static int[] EMOTICONS;
    private int maxPlus = 0;
    private int maxCost = 0;
    
    private void dfs(int[][] users, int[] dis, int count){
        int emoticonPlus = 0;
        int totalCost = 0;
        if(count == dis.length){
            for(int[] user: users){
                int personalCost = 0;
                for(int i = 0; i < EMOTICONS.length; i++){
                    if(user[0] <= dis[i]){
                        personalCost += EMOTICONS[i] * (100 - dis[i]) / 100;
                    }
                }
                if(personalCost >= user[1]){
                    emoticonPlus++;
                }else totalCost += personalCost;
            }
            if(maxPlus < emoticonPlus){
                maxPlus = emoticonPlus;
                maxCost = totalCost;
            }else if(maxPlus == emoticonPlus && maxCost < totalCost){
                maxCost = totalCost;
            }
        } else{
            while(dis[count] <= 30){
                dis[count] += 10;
                dfs(users, (int[]) dis.clone(), count + 1);
            }
        }
        
        
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        EMOTICONS = emoticons;
        int[] discounts = new int[emoticons.length];
        dfs(users, discounts, 0);
        return new int[]{maxPlus, maxCost};
    }
}