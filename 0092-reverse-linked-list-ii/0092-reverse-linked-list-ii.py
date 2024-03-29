# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        root = start = ListNode(None)
        start.next = head
        
        if head.next is None:
            return head
        
        for _ in range(left-1):
            start = start.next
        end = start.next
        
        for _ in range(right-left):
            tmp, start.next, end.next = start.next, end.next, end.next.next
            start.next.next = tmp
        
        return root.next
        
        
        