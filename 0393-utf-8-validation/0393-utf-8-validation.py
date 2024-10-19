class Solution:

    def validUtf8(self, data: List[int]) -> bool:

        def check(count: int) -> bool:
            for i in range(start + 1, start + count + 1):
                if i >= len(data) or bin(data[i] >> 6) != "0b10":
                    return False
                

        start = 0
    
        while start < len(data):
            if bin(data[start] >> 3) == "0b11110":
                if check(3) == False: return False
                start += 4
            elif bin(data[start] >> 4) == "0b1110":
                if check(2) == False: return False
                start += 3
            elif bin(data[start] >> 5) == "0b110":
                if check(1) == False: return False
                start += 2
            elif bin(data[start] >> 7) == "0b0":
                start += 1
            else: return False

        return True

        
