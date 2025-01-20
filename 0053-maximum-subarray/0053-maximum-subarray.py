class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        best_num = -sys.maxsize
        cur_num = 0

        for num in nums:
            cur_num = max(num, cur_num + num)
            best_num = max(best_num, cur_num)
        
        return best_num

