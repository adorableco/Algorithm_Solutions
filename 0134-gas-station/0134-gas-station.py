class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        if sum(gas) - sum(cost) < 0:
            return -1

        fuel = 0
        result = 0
        for i in range(len(gas)):
            if fuel + gas[i] - cost[i] < 0:
                fuel = 0
                result = i + 1

            else : fuel += gas[i] - cost[i]
        
        return result