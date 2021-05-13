class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        i = 0
        curr_num = 1
        while i < len(arr) and k > 0:
            if curr_num == arr[i]:
                i += 1
            else:
                k -= 1
            curr_num += 1

        
        return curr_num + k - 1
            
        