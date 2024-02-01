class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        prev = []
        result = []
        _next = []
        
        def dfs(nums: List[int]):
            if len(nums) == 0:
                result.append(prev[:])
                
            for num in nums:
                elements = nums[:]
                if num not in prev:
                    prev.append(num)
                    elements.remove(num)
                    dfs(elements)
                    prev.pop()
        
        dfs(nums)
        return result
                