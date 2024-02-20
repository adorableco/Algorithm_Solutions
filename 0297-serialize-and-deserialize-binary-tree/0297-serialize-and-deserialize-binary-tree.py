# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        
        if not root:
            return ""
        
        result = []
        queue = collections.deque([root])
        
        while(queue):
            node = queue.popleft()
            if node:
                result.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
            else:
                result.append("x")
        return ' '.join(result)
        

    def deserialize(self, data):
        
        if not data:
            return []
        
        data = data.split(' ')
        
        root = TreeNode(data[0])
        queue = collections.deque([root])
        
        for i in range(1,len(data)):
            
            if i%2!=0:
                node = queue[0]
                if data[i] == "x": node.left = None
                else:
                    node.left = TreeNode(data[i])
                    queue.append(node.left)
                
            else:
                node = queue.popleft()
                if data[i] == "x": node.right = None
                else:
                    node.right = TreeNode(data[i])
                    queue.append(node.right)
                i += 1
            
        return root
            
            
        

        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))