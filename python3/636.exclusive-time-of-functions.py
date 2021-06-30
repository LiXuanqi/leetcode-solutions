class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        ans = [0] * n
        
        events = []
        
        for log in logs:
            args = log.split(':')
            events.append(
                (
                    int(args[0]), 
                    args[1], 
                    # make 'start' and 'end' in same time scale.
                    int(args[2]) + int(args[1] == 'end')
                )
            )
            
        stack = []
        
        last_time = 0
        
        for id, type, timestamp in events:
            
            if type == 'start':
                if stack:
                    ans[stack[-1]] += (timestamp - last_time)
                stack.append(id)
                last_time = timestamp
                
            elif type == 'end':
                ans[stack[-1]] += (timestamp - last_time)
                stack.pop()
                
            last_time = timestamp
                
            
            
        return ans
                
        
