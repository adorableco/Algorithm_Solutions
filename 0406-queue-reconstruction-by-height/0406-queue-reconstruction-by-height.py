class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        heap = []

        for p in people:
            heapq.heappush(heap, (-p[0], p[1]))
        
        result = []

        while heap:
            item = heapq.heappop(heap)

            result.insert(item[1], [-item[0], item[1]])

        return result    