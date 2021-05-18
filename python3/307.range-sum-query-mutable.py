class NumArray:

    def __init__(self, nums: List[int]):
        self.size = len(nums)
        self.tree = [0] * (self.size * 4)
        
        build(self.tree, nums, 0, 0, self.size - 1)
        

    def update(self, index: int, val: int) -> None:
        return update(self.tree, 0, 0, self.size - 1, index, val)

    def sumRange(self, left: int, right: int) -> int:

        return query(self.tree, 0, 0, self.size - 1, left, right)
        
def build(tree, nums, node, start, end):
    if start == end:
        tree[node] = nums[start]
    else:
        mid = (start + end) // 2
        left_node = node * 2 + 1
        right_node = node * 2 + 2
        
        build(tree, nums, left_node, start, mid)
        build(tree, nums, right_node, mid + 1, end)
        
        push_up(tree, node)
        
def update(tree, node, start, end, index, val):
    if start == end:
        tree[node] = val
    else:
        mid = (start + end) // 2
        left_node = node * 2 + 1
        right_node = node * 2 + 2
        if index <= mid:
            update(tree, left_node, start, mid, index, val)
        else:
            update(tree, right_node, mid + 1, end, index, val)
            
        push_up(tree, node)
            
def query(tree, node, start, end, L, R):
    if L <= start and end <= R:
        return tree[node]
    
    mid = (start + end) // 2
    left_node = node * 2 + 1
    right_node = node * 2 + 2
    
    ans = 0
    
    if L <= mid:
        ans += query(tree, left_node, start, mid, L, R)
    
    if R > mid:
        ans += query(tree, right_node, mid + 1, end, L, R)
        
    return ans
    
        
def push_up(tree, node):
    left_node = node * 2 + 1
    right_node = node * 2 + 2
    tree[node] = tree[left_node] + tree[right_node]

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)
