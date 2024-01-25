class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        table, total = [0 for i in range(58)], 0
        
        for stn in stones:
            table[ord(stn)-65] += 1
        
        for jewel in jewels:
            total += table[ord(jewel)-65]    
        
        return total