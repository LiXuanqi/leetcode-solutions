class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        indexes = coordinate_compression(positions)
        
        tree = [0] * (4 * len(indexes))
        lazy = [0] * (4 * len(indexes))
        
        ans = []
        # print(indexes) 
        
        for left, length in positions:
            right = left + length - 1
            h = query(tree, lazy, 0, 0, len(indexes) - 1, indexes[left], indexes[right])
           
            update(tree, lazy, 0, 0, len(indexes) - 1, indexes[left], indexes[right], h + length)
            
          
            ans.append(tree[0])
           
            
        return ans
    
def query(tree, lazy, node, start, end, L, R):
    if L <= start and end <= R:
        return tree[node]
    
    push_down(tree, lazy, node)
    mid = (start + end) // 2
    ans = 0
    if L <= mid:
        ans = max(ans, query(tree, lazy, node * 2 + 1, start, mid, L, R))
        
    if R > mid:
        ans = max(ans, query(tree, lazy, node * 2 + 2, mid + 1, end, L, R))
        
    return ans
    
def update(tree, lazy, node, start, end, L, R, val):
    if L <= start and end <= R:
        tree[node] = max(val, tree[node])
        lazy[node] = max(val, lazy[node])
        return
    
    push_down(tree, lazy, node)
    
    mid = (start + end) // 2
    if L <= mid:
        update(tree, lazy, node * 2 + 1, start, mid, L, R, val)
        
    if R > mid:
        update(tree, lazy, node * 2 + 2, mid + 1, end, L, R, val)
        
    push_up(tree, node)

def push_up(tree, node):
    tree[node] = max(tree[node * 2 + 1], tree[node * 2 + 2])
    
def push_down(tree, lazy, node):
    if lazy[node]:
        lazy[node * 2 + 1] = max(lazy[node], lazy[node * 2 + 1])
        lazy[node * 2 + 2] = max(lazy[node], lazy[node * 2 + 2])
        tree[node * 2 + 1] = max(lazy[node], tree[node * 2 + 1])
        tree[node * 2 + 2] = max(lazy[node], tree[node * 2 + 2])
        lazy[node] = 0
        
        
def coordinate_compression(positions):
    coordinates = set()
    for left, length in positions:
        coordinates.add(left)
        coordinates.add(left + length - 1)

    return { coordinate: index for index, coordinate in enumerate(sorted(coordinates))}
