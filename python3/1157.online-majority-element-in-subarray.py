class MajorityChecker:

    def __init__(self, arr: List[int]):
        self.tree = [None] * (len(arr) * 4)
        self.arr = arr
        self.indexes = collections.defaultdict(list)
        
        self._build(0, 0, len(arr) - 1)
        
    def _build(self, node, start, end):
        if start == end:
            self.tree[node] = (self.arr[start], 1)
            self.indexes[self.arr[start]].append(start)
            return
        mid = (start + end) // 2
        self._build(node * 2 + 1, start, mid)
        self._build(node * 2 + 2, mid + 1, end)
        self._push_up(node)
        
    def _query(self, node, start, end, L, R):
        if L <= start and end <= R:
            return self.tree[node]
        mid = (start + end) // 2
        
        ans = None
        if L <= mid:
            ans = merge(ans, self._query(node * 2 + 1, start, mid, L, R))
        if mid < R:
            ans = merge(ans, self._query(node * 2 + 2, mid + 1, end, L, R))
        return ans
            
        
    def _push_up(self, node):
        self.tree[node] = merge(self.tree[node * 2 + 1], self.tree[node * 2 + 2])
        
        

    def query(self, left: int, right: int, threshold: int) -> int:
        candidate = self._query(0, 0, len(self.arr) - 1, left, right)
        candidate_num = candidate[0]
        
        count = self._count_between_range(candidate_num, left, right)
        if count >= threshold:
            return candidate_num
        return -1
        
    def _count_between_range(self, num, left, right):
      
        l = bisect.bisect_left(self.indexes[num], left)
        r = bisect.bisect_right(self.indexes[num], right)
        
        return r - l
        
        
def merge(pair_a, pair_b):
    if pair_a is None:
        return pair_b
    if pair_b is None:
        return pair_a
    
    if pair_a[0] == pair_b[0]:
        return (pair_a[0], pair_a[1] + pair_b[1])
    else:
        if pair_a[1] > pair_b[1]:
            return (pair_a[0], pair_a[1] - pair_b[1])
        else: 
            return (pair_b[0], pair_b[1] - pair_a[1])
        
        



# Your MajorityChecker object will be instantiated and called as such:
# obj = MajorityChecker(arr)
# param_1 = obj.query(left,right,threshold)
