class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        path = []
    
        graph = collections.defaultdict(list)

        for x,y in sorted(tickets):
            graph[x].append(y)

        def dfs(dest):
            while graph[dest]:
                dfs(graph[dest].pop(0))
            path.append(dest)
            
        
        dfs("JFK")
        return path[::-1]
            
    
    