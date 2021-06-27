class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True
        
        count = 0
        flowerbed = [0] + flowerbed + [0]
        for i in range(1, len(flowerbed) - 1):
            if not any(flowerbed[i - 1: i + 2]):
                count += 1
                flowerbed[i] = 1
                
                if count == n:
                    return True
                
        return False
            
        
