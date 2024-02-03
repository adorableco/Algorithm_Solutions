class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []
        prev = []
        _next = []
    
        def dfs(nums: List, target: int) -> None:
            if target == 0:
                result.append(prev[:])
            if target < 0:
                return
            
            _next = nums[:]           
            for i in range(len(nums)):
                prev.append(nums[i])
                dfs(_next[i:], target-nums[i])
                prev.pop()
        

        dfs(candidates,target)
        
        return result
                
                
            