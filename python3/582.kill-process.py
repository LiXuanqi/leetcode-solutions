class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        # build the tree and find all children.
        tree = {}
        for id, parent in zip(pid, ppid):
            tree.setdefault(parent, []).append(id)
            
        return self.find_children(kill, tree)
    
    def find_children(self, root, tree):
        if root not in tree:
            return [root]
        ans = [root]
        for child in tree[root]:
            ans += self.find_children(child, tree)
        return ans
        
        