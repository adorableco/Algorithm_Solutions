class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def binary_search(left, right, tar):
            if left <= right:
                middle = left + (right - left) // 2

                if sort[middle] < tar:
                    return binary_search(left + 1, right, tar)
                
                elif sort[middle] > tar:
                    return binary_search(left, right - 1, tar)
                
                else: return middle
            
            else: return -1

        sort = sorted(nums)

        target_pos = binary_search(0, len(sort) - 1, target)

        if target_pos == -1: return -1

        head = binary_search(0, len(sort) - 1, nums[0])

        if nums[0] > target:
            return len(sort) - head + target_pos
        
        else:
            return target_pos - head 
