class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        prev = []
        next_ = []
        result = []
        
        def dfs(array: List[int]) -> None:
            if len(prev) == k:
                result.append(prev[:])
                
            for i in range(len(array)):
                if array[i] not in prev:
                    prev.append(array[i])
                    next_ = array[i:].copy()
                    dfs(next_)
                    prev.pop()
            return
        
        dfs([j for j in range(1,n+1)])
        return result
            
