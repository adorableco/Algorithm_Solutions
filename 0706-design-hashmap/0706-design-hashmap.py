class ListNode:
    def __init__(self, key= None, val = None):
        self.next = None
        self.key = key
        self.val = val
        
class MyHashMap:

    def __init__(self):
        self.array = collections.defaultdict(ListNode)
        self.capacity = 1000
        
    def put(self, key: int, value: int) -> None:
        node = self.array[key % self.capacity]
        if node.val is None:
            self.array[key % self.capacity] = ListNode(key, value)
        else:
            while node:
                if node.key == key:
                    node.val = value
                    return
                if node.next is None:
                    break
                node = node.next
            node.next = ListNode(key, value)
                

    def get(self, key: int) -> int:
        node = self.array[key % self.capacity]
        
        if self.array[key % self.capacity].val is None:
            return -1
        else:
            while node:
                if node.key == key:
                    return node.val
                node = node.next
        return -1
        

    def remove(self, key: int) -> None:
        node = self.array[key % self.capacity]
        
        if self.array[key % self.capacity].val is None:
            return
        if node.key == key:
            if node.next is not None:
                self.array[key % self.capacity] = node.next
            else: self.array[key % self.capacity] = ListNode()
            return
        
        while node.next:
            if node.next.key == key:
                p = node.next.next
                node.next = p
                return
            node = node.next
        return
                    
                


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)