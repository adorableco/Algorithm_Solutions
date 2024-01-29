class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        prev = []
        next_ = []
        
        def dfs(elements: List[int]) -> None:
            if len(elements) == 0:
                result.append(prev[:])
                                
            for i in range(len(elements)):
                if elements[i] not in prev:
                    next_ = elements[:]   
                    next_.remove(elements[i])    
                    prev.append(elements[i])
                    dfs(next_)
                    prev.pop()
        
        dfs(nums)
        return result
                
                