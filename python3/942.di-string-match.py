class Solution:
    def diStringMatch(self, S: str) -> List[int]:
        if not S:
            return []
        nums = collections.deque([num for num in range(len(S) + 1)])
        ans = []
        
        for c in S:
            if c == "I":
                ans.append(nums.popleft())
            else:
                ans.append(nums.pop())
        ans.append(nums.pop())
        
        return ans