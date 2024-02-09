# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        q = collections.deque()
        q.append(root)
        level = collections.defaultdict(int)
        
        if not root:
            return 0
        
        if not root.left and not root.right:
            return 1
        
        
        while(q):
            node = q.popleft()
            if node.left or node.right:
                level[node] += 1
                
                if node.left:
                    q.append(node.left)
                    level[node.left] = level[node]
                    
                if node.right:
                    q.append(node.right)
                    level[node.right] = level[node]
                
                    
        return max(level.values()) + 1
            
            