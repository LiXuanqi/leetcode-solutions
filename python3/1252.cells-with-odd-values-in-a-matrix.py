class Solution:
    def oddCells(self, n: int, m: int, indices: List[List[int]]) -> int:
        row_counter = {}
        col_counter = {}
        for row, col in indices:
            row_counter[row] = row_counter.get(row, 0) + 1
            col_counter[col] = col_counter.get(col, 0) + 1
        ans = 0
        for row in range(n):
            for col in range(m):
                if (row_counter.get(row, 0) + col_counter.get(col, 0)) % 2 != 0:
                    ans += 1
        return ans