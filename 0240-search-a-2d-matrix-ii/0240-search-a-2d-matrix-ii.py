class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool: 
        x, y = 0, len(matrix[0]) - 1

        while y >= 0 and x < len(matrix):
            
            if matrix[x][y] > target:
                y -= 1
            
            elif matrix[x][y] < target:
                x += 1
            
            else: return True
        
        return False
