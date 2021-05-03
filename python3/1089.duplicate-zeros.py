class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        zero_counts = 0
        for num in arr:
            zero_counts += (1 if num == 0 else 0)
        
        virtual_len = len(arr) + zero_counts
        
        count = 0
        
        for i in range(len(arr) - 1, -1, -1):
            vitual_index = virtual_len - 1 - count
            if arr[i] == 0:
                if vitual_index < len(arr):
                    arr[vitual_index] = 0
                if vitual_index - 1 < len(arr):
                    arr[vitual_index - 1] = 0
                
                count += 2
            else:
                if vitual_index < len(arr):
                    arr[vitual_index] = arr[i]
                count += 1
                
                
            
            
