# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        result = ListNode(0)
        result_root = result
        reverse = None
        node = head
        cnt = 1
        
        while(cnt < left):
            result.next = ListNode(node.val)
            result = result.next
            node = node.next
            cnt += 1
        
        while(cnt <= right):
            next, node.next = node.next, reverse
            reverse, node = node, next
            cnt += 1
            
        result.next = reverse
        
        while(result and result.next):
            result = result.next
        
        while(node):
            result.next = node
            result = result.next
            node = node.next
        
        return result_root.next
            