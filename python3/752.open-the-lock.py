START = '0000'

class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        if START in deadends or target in deadends:
            return -1
        
        deadends = set(deadends)
        
        queue = collections.deque()
        visited = set()
        
        queue.append(START)
        visited.add(START)
        
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr == target:
                    return ans
                
                for next_lock in get_nexts(curr):
                    if next_lock not in deadends and next_lock not in visited:
                        queue.append(next_lock)
                        visited.add(next_lock)
                
            ans += 1
            
        return -1
                
                
def get_nexts(start):
    nexts = []
    
    for i in range(len(start)):
        nexts.append(start[:i] + get_num(int(start[i]) + 1) + start[i + 1:]) 
        nexts.append(start[:i] + get_num(int(start[i]) - 1) + start[i + 1:])     
            
    return nexts    
    
    
def get_num(num):
    if num == 10:
        return '0'
    elif num == -1:
        return '9'
    else:
        return str(num)
