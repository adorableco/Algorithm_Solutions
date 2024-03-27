# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if not (head and head.next):
            return head
            
        node, slow, fast = None, head, head
        
        while(fast and fast.next):
            node, slow, fast = slow, slow.next, fast.next.next
        
        node.next = None
        
        l1 = self.sortList(head)
        l2 = self.sortList(slow)
        
        return self.mergeTwoLists(l1,l2)
    
    def mergeTwoLists(self, l1: ListNode, l2:ListNode) -> Optional[ListNode]:
        
        if l1 and l2:
            if l1.val > l2.val:
                l1, l2 = l2, l1
            
            l1.next = self.mergeTwoLists(l1.next, l2)
        
        return l1 or l2
                
        
        
        
        
        
        