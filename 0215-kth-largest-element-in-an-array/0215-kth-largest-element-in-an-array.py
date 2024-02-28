class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        queue = []
        output = []
        
        for num in nums:
            heapq.heappush(queue, num)
        
        for _ in range(len(nums)):
            output.append(heapq.heappop(queue))
        
        
        return output[-k]
        