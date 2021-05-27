class Solution:
    def countPairs(self, n: int, edges: List[List[int]], queries: List[int]) -> List[int]:
        # degrees[a] + degrees[b] - edge_count(a, b) > query
        degrees = [0] * (n + 1)
        edge_count = collections.defaultdict(int)
        for a, b in edges:
            degrees[a] += 1
            degrees[b] += 1
            edge_count[(min(a, b), max(a, b))] += 1

        # print(degrees)
        sorted_degrees = sorted(degrees)
        # print(degrees)
        # print(edge_count)
        ans = []
        
        for query in queries:
            left = 1
            right = len(degrees) - 1
            curr_ans = 0
            while left < right:
                if sorted_degrees[left] + sorted_degrees[right] > query:
                    curr_ans += (right - left)
                    right -= 1
                else:
                    left += 1
            # print(curr_ans) 
            for edge, count in edge_count.items():
                a, b = edge
                if degrees[a] + degrees[b] > query and degrees[a] + degrees[b] - count <= query:
                    # print(a, b)
                    curr_ans -= 1
                        
            ans.append(curr_ans)
        return ans
           
                
                
            
