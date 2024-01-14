# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if head is None:
            return head
        
        left, right, right_head = head, head.next, head.next
        
        while(right and right.next):
            right.next, left.next = right.next.next, left.next.next
            left, right = left.next, right.next
        
        left.next = right_head
        return head
            