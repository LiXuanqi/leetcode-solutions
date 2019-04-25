class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        if not picture:
            return 0
        rows = [0] * len(picture)
        cols = [0] * len(picture[0])
        for x in range(len(picture)):
            for y in range(len(picture[0])):
                if picture[x][y] == 'B':
                    rows[x] += 1
                    cols[y] += 1
        ans = 0
        for x in range(len(picture)):
            for y in range(len(picture[0])):
                if picture[x][y] == 'B' and rows[x] == 1 and cols[y] == 1:
                    ans += 1
        return ans
                    