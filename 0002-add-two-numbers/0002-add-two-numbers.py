# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def toList(self,li: Optional[ListNode])-> []:
        array = []
        
        while(li):
            array.append(li.val)
            li = li.next
            
        return array
    
    def reversedListNode(self,li: Optional[ListNode]) -> Optional[ListNode]:
        node, prev = li, None
        
        while(node):
            next, node.next = node.next, prev
            prev, node = node, next
        
        return prev
    
    def toListNode(self,li: str)-> Optional[ListNode]:
        root = node = ListNode(0)
        
        for i in li:
            node.next = ListNode(i)
            node = node.next
            
        return root.next
            
        
        
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        str1 = int(''.join([str(e) for e in self.toList(self.reversedListNode(l1))]))
        str2 = int(''.join([str(e) for e in self.toList(self.reversedListNode(l2))]))
        
        return self.reversedListNode(self.toListNode(str(str1+str2)))

        
        
            
                
                
        
        