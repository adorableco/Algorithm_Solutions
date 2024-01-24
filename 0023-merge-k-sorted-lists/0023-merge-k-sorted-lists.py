# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        root = result = ListNode(0)
        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i, lists[i]))    
        
        while(heap):
            node = heapq.heappop(heap)
            index = node[1]
            result.next  = ListNode(node[0])
            result = result.next
            
            if node[2].next:
                heapq.heappush(heap, (node[2].next.val,index , node[2].next))
        
        return root.next
            
                
                    
            