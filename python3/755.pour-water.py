class Solution:
    def pourWater(self, heights: List[int], volume: int, k: int) -> List[int]:
        
        for _ in range(volume):
            drop_index = k
            # move left
            while drop_index > 0 and heights[drop_index - 1] <= heights[drop_index]:
                drop_index -= 1
            # move right
            while drop_index < len(heights) - 1 and heights[drop_index + 1] <= heights[drop_index]:
                drop_index += 1
                
            while drop_index > k and heights[drop_index - 1] == heights[drop_index]:
                drop_index -= 1
            
            heights[drop_index] += 1
            
        return heights

    
