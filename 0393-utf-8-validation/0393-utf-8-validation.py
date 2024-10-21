class Solution:


    def validUtf8(self, data: List[int]) -> bool:

        def check(count: int) -> bool:
            for i in range(index + 1, index + count + 1):
                if i >= len(data) or data[i] >> 6 != 0b10:
                    return False
            return True
        
        index = 0

        while index < len(data):
            start = data[index]

            if start >> 3 == 0b11110 and check(3):
                index += 4
            elif start >> 4 == 0b1110 and check(2):
                index += 3
            elif start >> 5 == 0b110 and check(1):
                index += 2
            elif start >> 7 == 0b0:
                index += 1
            else: return False

        return True

        
