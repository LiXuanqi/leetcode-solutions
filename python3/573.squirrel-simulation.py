class Solution:
    def minDistance(self, height: int, width: int, tree: List[int], squirrel: List[int], nuts: List[List[int]]) -> int:
        
        total = sum(calculate_distance(tree, nut) for nut in nuts) * 2
        
        return min(total - calculate_distance(tree, nut) + calculate_distance(squirrel, nut)  for nut in nuts)
        
        
        
def calculate_distance(point_1, point_2):
    return abs(point_1[0] - point_2[0]) + abs(point_1[1] - point_2[1])
