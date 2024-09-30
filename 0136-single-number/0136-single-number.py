class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        i = 1
        result = nums[0]

        while i < len(nums): 
            result = (result & ~nums[i]) | (~result & nums[i])
            i += 1

        return result

            