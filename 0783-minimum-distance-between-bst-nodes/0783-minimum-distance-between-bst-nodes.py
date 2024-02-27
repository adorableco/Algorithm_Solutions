# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = -sys.maxsize
    now = sys.maxsize
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        
        if root:
            self.minDiffInBST(root.left)
            self.now = min(self.now, root.val - self.prev)
            self.prev = root.val
            self.minDiffInBST(root.right)
        
        return self.now
             


        