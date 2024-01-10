class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        min_value = prices[0]
        max_value = 0
        
        for i in range(len(prices)):
            min_value = min(prices[i], min_value)
            max_value = max(max_value, prices[i]-min_value)
        return max_value