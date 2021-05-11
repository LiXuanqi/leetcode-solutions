class Solution:
    def minTransfers(self, transactions: List[List[int]]) -> int:
        bills = collections.defaultdict(int)
        for start, to, money in transactions:
            bills[start] -= money
            bills[to] += money
        
        debts = []
        
        for value in bills.values():
            if value != 0:
                debts.append(value)
                
  
        
        def dfs(curr_index):
    
            while curr_index < len(debts) and debts[curr_index] == 0:
                curr_index += 1
            
            if curr_index == len(debts):
                return 0
            cost = float('inf')
            prev = 0
            for i in range(curr_index + 1, len(debts)):
                
                if debts[i] != prev and debts[i] * debts[curr_index] < 0:
                    
                    debts[i] += debts[curr_index]
                    cost = min(dfs(curr_index + 1) + 1, cost)
                    debts[i] -= debts[curr_index]
                    prev = debts[i]
            return cost
        
        ans = dfs(0)
        
        return ans if ans != float('inf') else -1
  
