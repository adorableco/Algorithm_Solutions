# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        array = []
        
        node = head
        while(node):
            array.append(node.val)
            node = node.next
        
        node = head
        
        for i in sorted(array):
            node.val = i
            node = node.next
        
        return head
            
        
        
        
        