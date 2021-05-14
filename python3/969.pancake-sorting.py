class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        ans = []
        
        n = len(arr)
        for i in range(n - 1, -1, -1):
            if arr[i] != i + 1:
                start_index = arr.index(i + 1)
                ans.append(move(arr, start_index))
                ans.append(move(arr, i))
                
        return ans
        
def move(arr, index):
    revert(arr, index)
    
    return index + 1

def revert(arr, index):
    left = 0
    right = index
    while left < right:
        temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        
        left += 1
        right -= 1
        
        
