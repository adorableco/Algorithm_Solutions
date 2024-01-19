class MyCircularQueue:

    def __init__(self, k: int):
        self.queue = [0 for i in range(k+1)]
        self.capacity = k+1
        self.front = 0
        self.rear  = 0

    def enQueue(self, value: int) -> bool:
        if not self.isFull():
            self.rear  = (self.rear + 1) % self.capacity
            self.queue[self.rear] = value
            return True
        else: return False


    def deQueue(self) -> bool:
        if not self.isEmpty():
            self.front = (self.front + 1) % self.capacity
            return True
        else: return False

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.queue[(self.front+1)%self.capacity]

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.queue[self.rear]

    def isEmpty(self) -> bool:
        if self.front == self.rear:
            return True
        else: return False

    def isFull(self) -> bool:
        if (self.rear+1)%self.capacity == self.front:
            return True
        else: return False
        


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()