class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <= 1:
            return len(s)
        if list(s)[0] == " ":
            return 1
        
        table = collections.defaultdict()
        array = list(s)
        left, right = 0,0
        
        while left < len(s) and right < len(s):
            
            if right+1 >= len(s) or array[right+1]  in s[left:right+1]:
                table[right+1-left] = s[left:right+1]
                left = left+1
                right = left
            else: right += 1
                
        
        return max(table)
            
            