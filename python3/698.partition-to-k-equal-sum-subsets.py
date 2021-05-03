class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        nums = sorted(nums, reverse=True)
        n = len(nums)
        total = sum(nums)
        target = total // k
        if total % k != 0:
            return False
        
        groups = [0] * k
        
        def dfs(index):
            if index == n:
                return True
            for group_id in range(k):
                    
                if groups[group_id] + nums[index] <= target:
                    groups[group_id] += nums[index]
                    if dfs(index + 1):
                        return True
                    groups[group_id] -= nums[index]
                    # NOTE: it's important!!!
                    if groups[group_id] == 0:
                        break
            return False
        
        return dfs(0)
        
