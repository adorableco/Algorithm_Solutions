class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        sort, s_set = sorted(s), set(s)
        
        for i in sort:
            index = s.index(i)
            if set(s[index:]) == s_set:
                return i + self.removeDuplicateLetters(s[index+1:].replace(i,''))

        return ''