class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        path = []
    
        graph = collections.defaultdict(list)

        for x,y in sorted(tickets, reverse = True):
            graph[x].append(y)

        def dfs(dest):
            while graph[dest]:
                dfs(graph[dest].pop())
            path.append(dest)
            
        
        dfs("JFK")
        return path[::-1]
            
    
    