class Solution:
    def isValid(self, s: str) -> bool:
        couple = {'(' : ')', '[': ']', '{':'}'}
        chars = list()
        
        for c in s:
            if c == '(' or c == '[' or c =='{':
                chars.append(c)
            else:
                if len(chars) < 1 or couple[chars.pop()] != c:
                    return False
        if chars:
            return False
        else: return True
            