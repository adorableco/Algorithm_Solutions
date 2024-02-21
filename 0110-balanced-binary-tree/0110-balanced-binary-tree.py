# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        if not root:
            return True
        table = []
        
        def dfs(node: Optional[TreeNode], height: int):
            left, right = height, height            
            
            if node:
                left = dfs(node.left,height+1)
                right = dfs(node.right, height+1)
                if abs(left-right) > 1:
                    table.append([left,right])
            return max(left,right)
            
        
        
        dfs(root,0)
        if len(table) > 0:
            return False
        return True
                
            
            
        

        
        
            
        