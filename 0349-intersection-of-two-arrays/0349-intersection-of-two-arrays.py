class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        left, right = 0, 0
        result = []

        nums1.sort()
        nums2.sort()

        while left < len(nums1) and right < len(nums2):
            if nums1[left] < nums2[right]:
                left += 1
            
            elif nums1[left] > nums2[right]:
                right += 1
            
            else:
                result.append(nums1[left])
                left += 1
                right += 1
        
        return set(result)