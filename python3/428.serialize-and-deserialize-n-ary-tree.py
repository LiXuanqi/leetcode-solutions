"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Codec:
    def serialize(self, root: 'Node') -> str:
        """Encodes a tree to a single string.
        
        :type root: Node
        :rtype: str
        """
        if root is None:
            return None
        if not root.children:
            return str(root.val)
        ans = ''
        for index, child in enumerate(root.children):
            ans += self.serialize(child)
            if index != len(root.children) - 1:
                ans += ' '
        ret =  f'{root.val}({ans})'
      
        return ret
        
        
	
    def deserialize(self, data: str) -> 'Node':
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: Node
        """
        if data is None:
            return None
        
        stack = []
        curr_str = ''
        for c in data:
            if c in '( )':
                if curr_str:
                    stack.append(Node(int(curr_str), []))
                    curr_str = ''
                    
                if c == '(':
                    stack.append('(')
                elif c == ')': 
                    children = []
                    while stack and stack[-1] != '(':
                        children.append(stack.pop())
                    stack.pop()
                    stack[-1].children = children[::-1]

            else:
                curr_str += c
                
        if curr_str:
            stack.append(Node(int(curr_str), []))
            
        root = stack[-1]
        return root
                
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
