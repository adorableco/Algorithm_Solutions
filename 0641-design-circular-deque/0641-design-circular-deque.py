class MyCircularDeque:

    def __init__(self, k: int):
        self.head, self.tail = ListNode(None), ListNode(None)
        self.k, self.len = k, 0
        self.head.right, self.tail.left = self.tail, self.head
        
    def __add(self, node: ListNode(), new: ListNode()):
        n = node.right
        node.right = new
        new.left, new.right = node, n
        n.left = new
        self.len += 1
        
    def __delete(self, node: ListNode()):
        node.right = node.right.right
        node.right.left = node
        self.len -= 1

    def insertFront(self, value: int) -> bool:
        if self.k == self.len:
            return False
        
        self.__add(self.head, ListNode(value))
        return True

    def insertLast(self, value: int) -> bool:
        if self.k == self.len:
            return False
        
        self.__add(self.tail.left, ListNode(value))
        return True
        

    def deleteFront(self) -> bool:
        if self.len <= 0:
            return False
        
        self.__delete(self.head)
        return True

    def deleteLast(self) -> bool:
        if self.len <= 0:
            return False
        
        self.__delete(self.tail.left.left)
        return True


    def getFront(self) -> int:
        if self.len <= 0:
            return -1
        
        return self.head.right.val

    def getRear(self) -> int:
        if self.len <= 0:
            return -1
        
        return self.tail.left.val

    def isEmpty(self) -> bool:
        return self.len <= 0

    def isFull(self) -> bool:
        return self.k == self.len


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()