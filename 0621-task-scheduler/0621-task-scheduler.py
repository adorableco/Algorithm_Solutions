class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counter = collections.Counter(tasks)

        result = 0

        while counter:
            temp_count = 0
            for k, _ in counter.most_common(n + 1):
                temp_count += 1
                result += 1

                counter.subtract(k)
                counter += collections.Counter()

            if counter:
                result += n - temp_count + 1
        
        return result

