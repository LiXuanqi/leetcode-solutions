class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        used = [None] * n
        ans = []
        
        def dfs(curr_index, tmp):
            if curr_index >= n:
                ans.append(tmp.copy())
                return
            for i in range(n):
                num = nums[i]
                if used[i]:
                    continue
                if i > 0 and nums[i - 1] == nums[i] and not used[i - 1]:
                    continue
                used[i] = True
                tmp.append(num)
                dfs(curr_index + 1, tmp)
                tmp.pop()
                used[i] = False
                
            
            
        dfs(0, [])
        return ans
        
