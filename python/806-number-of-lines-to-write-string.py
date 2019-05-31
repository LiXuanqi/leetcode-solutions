class Solution:
    def numberOfLines(self, widths: List[int], S: str) -> List[int]:
        if not widths or not S:
            return [0, 0]
        
        def getCharWidth(c):
            index = ord(c.lower()) - ord('a')
            return widths[index]
        
        lines = 1
        counter = 0
        
        for c in S:
            width = getCharWidth(c)
            counter += width
            if counter > 100:
                lines += 1
                counter = width
        return [lines, counter]