class Solution:
    def calculate(self, a, par , b) -> int:
        if par == '*': return a * b
        elif par == '-': return a - b
        elif par == '+': return a + b
    
    def diffWaysToCompute(self, expression: str) -> List[int]:
        total_result = []
        exp = re.split(r'(\*|-|\+)', expression)

        if len(exp) == 1:
            return [int(exp[0])]
        if len(exp) == 3:
            return [self.calculate(int(exp[0]), exp[1], int(exp[2]))]

        for i, c in enumerate(expression):
            if c.isdigit() == False:
                pre = self.diffWaysToCompute(expression[:i])
                post = self.diffWaysToCompute(expression[i+1:])
                
                for pre_i in pre:
                    for post_i in post:
                        r = self.calculate(pre_i, c, post_i)
                        total_result.append(r)
        
        if not total_result: total_result.append(int(expression))
        return total_result

