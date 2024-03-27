import collections

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        intervals = collections.deque(sorted(intervals))
        result = []
        
        while(intervals):
            
            if len(intervals) == 1:
                result.append(intervals.popleft())
                
            
            elif intervals[0][1] >= intervals[1][0]:
                if intervals[0][1] < intervals[1][1]:
                    new_list = [intervals[0][0], intervals[1][1]]
                else: new_list = intervals[0]
                    
                intervals.append(new_list)
                intervals.popleft()
                intervals.popleft()
                
            else:
                result.append(intervals.popleft())   
            
            intervals = collections.deque(sorted(list(intervals)))
        
        return result
                
                
            
        
        