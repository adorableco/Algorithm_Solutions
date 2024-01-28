class Solution:
    def letterCombinations(self, digits: str) -> None:
        def dfs(index: int, path: str) -> List[str]:
            if len(path) == len(digits):
                result.append(path)
                return
            
            for j in phone[digits[index]]:
                dfs(index + 1, path + j)
        if not digits:
            return []
            
        phone = {'2':"abc",'3':"def", '4': "ghi", '5': "jkl", '6':"mno", '7':"pqrs", '8':"tuv", '9':"wxyz"}
        result = []
        dfs(0 ,"")
        return result