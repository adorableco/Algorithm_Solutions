# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    minimum = sys.maxsize
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        
        def dfs(target: int, node: TreeNode) -> int:
            result = sys.maxsize
            
            if node.val <= target and node.right:
                result = dfs(target, node.right)

            elif node.val > target and node.left:
                result = dfs(target, node.left)
                    
            else:
                result = abs(node.val - target)
            
            return result
        
        minimum = sys.maxsize
        queue = collections.deque([root])
        while(queue):
            now = queue.popleft()
            print("queue = ",queue)
            if now.left:
                minimum = min(minimum, dfs(now.val, now.left))
                queue.append(now.left)
            if now.right:
                minimum = min(minimum, dfs(now.val, now.right))
                queue.append(now.right)
        
        return minimum

        