# Stack: O(n*2)
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        ans = [0] * len(T)
        for index, num in enumerate(T):
            while stack and num > T[stack[-1]]:
                last_index = stack.pop()
                ans[last_index] = index - last_index
            stack.append(index)
            
        return ans


# Hash Map: O(n * (100-30))
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        num_positions = collections.defaultdict(list)
        
        n = len(T)
        
        ans = [0] * n
        
        for i in range(n - 1, -1, -1):
            num = T[i]
            num_positions[num].append(i)
            ans[i] = find_closest_warmer_temperature(num, num_positions, i)
        
        return ans
        
        
        
def find_closest_warmer_temperature(num, num_positions, curr_index):
    #  Each temperature will be an integer in the range [30, 100].
    ans = float('inf')
    for candidate_num in range(num + 1, 101):
        if candidate_num in num_positions:
            ans = min(ans, num_positions[candidate_num][-1] - curr_index)
        
    return ans if ans != float('inf') else 0

# Brute Force: O(n^2)
