class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        nums.reverse()
        
        output = 0
        for i in range(1,len(nums),2):
            output += nums[i]
        return output