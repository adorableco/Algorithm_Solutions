def solution(sizes):
    answer = 0
    
    for size in sizes:
        if size[0] > size[1]:
            size[0], size[1] = size[1], size[0]
    
    a = max([size[0] for size in sizes])
    b = max([size[1] for size in sizes])
    
    return a * b