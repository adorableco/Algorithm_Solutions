class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:

        for k, v in enumerate(numbers):
            remain = target - v

            i = bisect.bisect_left(numbers, remain, k + 1)

            if i < len(numbers) and numbers[i] == remain:
                return [k + 1, i + 1]
