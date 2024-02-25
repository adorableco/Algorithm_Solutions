# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def dfs(array):
            if len(array) == 1:
                mid = (len(array)-1)//2
                node = TreeNode(array[mid])
                return node
            
            mid = (len(array)-1)//2
            node = TreeNode(array[mid])
            
            if mid != 0:
                node.left = dfs(array[:mid])

            node.right = dfs(array[mid+1:])

            return node
        
        return dfs(nums)
            