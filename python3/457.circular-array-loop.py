class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        if not nums:
            return False
        length = len(nums) 
        
        def move(curr):
            step = nums[curr]
            next = step + curr
            if next < 0:
                next += length
            return next % length 
                
        def hasCircle(start):
            slow = start
            fast = move(start)
            # same direction
            while nums[slow] * nums[fast] > 0 and nums[slow] * nums[move(fast)] > 0:
                if slow == fast:
                    return slow != move(slow) 
                slow = move(slow)
                fast = move(move(fast))
            return False
                    
        def markZeros(start):
            direction = nums[start]
            curr = start
            while direction * nums[curr] > 0:
                next = move(curr)
                nums[curr] = 0
                curr = next
            
        for start in range(len(nums)):
            if nums[start] == 0:
                continue
            if not hasCircle(start):
                markZeros(start)
            else:
                return True
        return False