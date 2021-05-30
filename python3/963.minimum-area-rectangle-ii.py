class Solution:
    def minAreaFreeRect(self, points: List[List[int]]) -> float:
        mid_point_to_pairs = collections.defaultdict(list)
        
        
        n = len(points)
        for i in range(n - 1):
            for j in range(i + 1, n):
                pair = (points[i], points[j])
                mid_point_to_pairs[mid_point(pair)].append(pair)
        
        ans = float('inf')
        
        for pairs in mid_point_to_pairs.values():
            m = len(pairs)
            for i in range(m - 1):
                for j in range(i + 1, m):
                    ans = min(ans, area(pairs[i], pairs[j])) 
                    
        return ans if ans != float('inf') else 0
                
def mid_point(pair):
    point_1, point_2 = pair
    return (point_1[0] + point_2[0]) / 2, (point_1[1] + point_2[1]) / 2
    
def area(pair_1, pair_2):
    point_1, point_2 = pair_1
    point_3, point_4 = pair_2
    # print(point_1, point_2,point_3,point_4)
    # print((point_3[0] - point_1[0]) * (point_4[0] - point_1[0]) + (point_3[1] - point_1[1]) * (point_4[1] - point_1[1]))
    if (point_3[0] - point_1[0]) * (point_4[0] - point_1[0]) + (point_3[1] - point_1[1]) * (point_4[1] - point_1[1]) != 0:
        return float('inf')
    
    return distance(point_1, point_3) * distance(point_1, point_4) 

def distance(point_1, point_2):
    return math.sqrt(abs(point_1[0] - point_2[0]) ** 2 + abs(point_1[1] - point_2[1]) ** 2)
        
