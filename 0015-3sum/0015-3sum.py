class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        output = []
        
        for i in range(len(nums)-2):
            if i > 0 and nums[i-1] == nums[i]:
                continue
            
            left, right = i+1, len(nums)-1
            
            while(left < right):
                
                sums = nums[left] + nums[right] + nums[i]
                
                if sums < 0:
                    left += 1

                elif sums > 0:
                    right -= 1

                else:
                    output.append([nums[i],nums[left],nums[right]])

                    while(left < right and nums[left+1] == nums[left]):
                        left += 1

                    while(left < right and nums[right-1] == nums[right]):
                        right -= 1
                
                    left += 1
                    right -= 1
                
        return output
            
            