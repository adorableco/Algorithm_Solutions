class Solution:
    def trap(self, height: List[int]) -> int:
        left,right = 0,len(height)-1
        max_left, max_right = height[left], height[right]
        
        output = 0
        while(left < right):
            max_left = max(height[left],max_left)
            max_right = max(height[right],max_right)            
            
            if height[left] <= height[right]:
                output += max_left - height[left]
                left += 1
            else:
                output += max_right - height[right]
                right -= 1
        return output
                