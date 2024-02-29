import collections

def solution(answers):
    answer = collections.defaultdict(int)
    one = [1, 2, 3, 4, 5]
    two = [2, 1, 2, 3, 2, 4, 2, 5]
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    
    for i in range(len(answers)):
        if one[i % 5] == answers[i]: answer[1] += 1
        if two[i % 8] == answers[i]: answer[2] += 1
        if three[i % 10] == answers[i]: answer[3] += 1        
    
    maximum = max(answer.values())
    result = []
    
    for key in answer.keys():
        if answer[key] == maximum:
            result.append(key)
            
    return sorted(result)