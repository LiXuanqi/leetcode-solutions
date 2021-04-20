class SnapshotArray:

    def __init__(self, length: int):
        self.events = {index: [] for index in range(length)}
        self.snapshot_id = -1
        

    def set(self, index: int, val: int) -> None:
        self.events[index].append((self.snapshot_id, val))
        

    def snap(self) -> int:
        self.snapshot_id += 1
        return self.snapshot_id
        

    def get(self, index: int, snap_id: int) -> int:
        events = self.events[index]
        target_index = find_right_most_index_smaller_snap_id(snap_id, events)
       
        return events[target_index][1] if target_index is not None else 0
        
def find_right_most_index_smaller_snap_id(snap_id, events):
    if not events:
        return None
   
    left = 0
    right = len(events) - 1
    
    while left + 1 < right:
        mid = (left + right) // 2
        mid_snap_id = events[mid][0]
        
        
        if mid_snap_id < snap_id:
            left = mid
        else:
            right = mid
    
    if events[right][0] < snap_id:
        return right
    if events[left][0] < snap_id:
        return left
    return None

# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
