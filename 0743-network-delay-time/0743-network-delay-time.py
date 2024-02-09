class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        result = collections.defaultdict(int)
        graph = collections.defaultdict(list)
        
        for x,y,z in times:
            graph[x].append((y,z))
            
        q = []
        heapq.heappush(q, (0,k))
        
        while(q):
            v, w = heapq.heappop(q)
            if w not in result:
                result[w] = v
                for node, time in graph[w]:
                    heapq.heappush(q,(time+v, node))
                
        if len(result) == n:        
            return max(result.values())
        return -1
            
            
            
            