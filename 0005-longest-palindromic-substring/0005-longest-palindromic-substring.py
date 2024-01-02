class Solution:
    def longestPalindrome(self, s: str) -> str:
        result = []
        
        def findPalin(left, right):
            while left > 0 and right < len(s):
                if s[left-1:right+1] == s[left-1:right+1][::-1]:
                    left -= 1
                    right += 1
                else:
                    return s[left:right]
            return s[left:right]
            

        if len(s) <= 1:
            return s
            
        for i in range(len(s)):
            if s[i:i+3] == s[i:i+3][::-1]:
                result.append(findPalin(i,i+3))
            
            if s[i:i+2] == s[i:i+2][::-1]:
                result.append(findPalin(i,i+2))
        
        result.sort(key=len)
        return result[len(result)-1]
            