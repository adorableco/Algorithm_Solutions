class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        dist = []
        result = []
        max_num = sys.maxsize
        
        for point in points:
            dist.append(point[0] ** 2 + point[1] ** 2)  
        
        for i in range(k):
            index = dist.index(min(dist))
            result.append(points[index])
            dist[index] = max_num
        
        return result
                