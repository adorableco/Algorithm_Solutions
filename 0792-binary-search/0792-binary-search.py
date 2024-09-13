class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def binary_search(left, right):
            
            if left <= right:
                middle = left + (right - left) // 2

                if nums[middle] < target:
                    return binary_search(middle + 1, right)

                elif nums[middle] > target:
                    return binary_search(left, middle - 1)

                else: return middle
            
            else: return -1
            
        return binary_search(0, len(nums) - 1)
            
            