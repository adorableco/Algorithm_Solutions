class Solution:

    def compareTwoNum(self,a, b) -> bool :
        return int(str(a)+str(b)) < int(str(b)+str(a))
    
        
    def largestNumber(self, nums: List[int]) -> str:
        
        for i in range(len(nums)-1):
            j = i + 1
            while(j > 0 and self.compareTwoNum(nums[j-1], nums[j])):
                nums[j-1], nums[j] = nums[j], nums[j-1]
                j -= 1
        
        
        return str(int("".join(map(str, nums))))
            
                
                
        