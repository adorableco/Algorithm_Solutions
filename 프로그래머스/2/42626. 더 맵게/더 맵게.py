import heapq

def solution(scoville, K):
    cnt =  0
    
    heapq.heapify(scoville)
    
    if scoville[0] >= K:
        return 0
    
    while(scoville and scoville[0] < K):
        
        if len(scoville) <= 1:
            return -1
        
        cnt += 1
        least1 = heapq.heappop(scoville)
        least2 = heapq.heappop(scoville)
        heapq.heappush(scoville, least1 + (least2 * 2))
        
    return cnt