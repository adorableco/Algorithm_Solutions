# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    longest = 0
    
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        
        def dfs(node: TreeNode):
            
            if not node:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)
            
            dist = 0
            left_temp = 0
            right_temp = 0
            
            if node.left and node.left.val == node.val:
                dist += left
                left_temp = left
            if node.right and node.right.val == node.val:
                dist += right
                right_temp = right
            self.longest = max(self.longest, dist)
            
            return max(left_temp, right_temp) + 1
            
        dfs(root)
        return self.longest