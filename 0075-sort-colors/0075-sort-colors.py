class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero = nums.count(0)
        one = nums.count(1)
        
        for i in range(zero):
            nums[i] = 0
            
        for i in range(one):
            nums[zero + i] = 1
            
        for i in range(len(nums) - zero - one):
            nums[one + zero + i] = 2
                