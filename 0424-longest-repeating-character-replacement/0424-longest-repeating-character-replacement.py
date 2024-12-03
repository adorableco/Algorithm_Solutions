class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        left = 0
        counter = collections.Counter()

        for right in range(len(s)):
            counter[s[right]] += 1

            if (right - left + 1) - counter.most_common(1)[0][1] - k > 0:
                counter[s[left]] -= 1
                left += 1
        
        return right - left + 1


