class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        visited = set()
        traced = set()
        
        graph = collections.defaultdict(list)
        
        for x,y in prerequisites:
            graph[x].append(y)
        
        def dfs(i):
            if i in traced:
                return False
            
            if i in visited:
                return True
            
            for x in graph[i]:
                traced.add(i)
                if not dfs(x):
                    return False
                traced.remove(i)
                
            visited.add(i)
            
            return True
                
        
        for x in list(graph):
            if not dfs(x):
                return False
        
        return True
            
            
            