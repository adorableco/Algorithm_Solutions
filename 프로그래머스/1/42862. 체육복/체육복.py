import collections

def solution(n, lost, reserve):
    status = [1] * (n + 1)
    for x in lost:
        status[x] -= 1
    for x in reserve:
        status[x] += 1
    
    for i in range(1, n+1):
        
        if i != 1 and status[i] == 2 and status[i - 1] == 0:
            status[i] -= 1
            status[i - 1] += 1
        
        if i != n and status[i] == 2 and status[i + 1] == 0:
            status[i] -= 1
            status[i + 1] += 1
    
    return n - status.count(0)