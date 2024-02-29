import collections
import sys

def solution(n, edge):
    graph = collections.defaultdict(list)
    
    visited = [0] * (n + 1)
    visited[1] = 1
    answer = collections.defaultdict(int)
    
    for x,y in edge:
        graph[x].append(y)
        graph[y].append(x)
    
    queue = collections.deque([[1,0]])
    
    while(queue):
        node, path =  queue.popleft()
        answer[node] = path
        
        for x in graph[node]:
            if visited[x] == 0:
                visited[x] = 1
                queue.append((x,path + 1))
                

    return list(answer.values()).count(max(answer.values()))
