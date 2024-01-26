class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = collections.Counter(nums).most_common()
        result = [key for key,value in count]
        
        return result[:k]