# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast, slow = head,head
        rev = slow
        
        while(fast is not None and fast.next is not None):
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next
        
        if fast:
            slow = slow.next
            
        while rev and slow:
            if rev.val == slow.val:
                rev, slow = rev.next, slow.next
            else: return False
        return True
        
        
        