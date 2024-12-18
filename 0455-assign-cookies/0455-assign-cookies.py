class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        result = 0

        g.sort(reverse = True)
        s.sort()
        cookies = collections.deque(s)

        for i in range(len(g)):
            if not cookies:
                break 

            if cookies[len(cookies) - 1] >= g[i]:
                cookies.pop()
                result += 1
        
        return result
