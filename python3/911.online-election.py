class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.vote_stats = []
        max_vote = float('-inf')
        max_voter = None
        counter = collections.defaultdict(int)
        for person, time in zip(persons, times):
            counter[person] += 1
            if counter[person] >= max_vote:
                max_vote = counter[person]
                max_voter = person
            self.vote_stats.append((time, max_voter))

    def q(self, t: int) -> int:
        # print(self.vote_stats)
        # print(t)
        index = find_last_less_or_equals_position(self.vote_stats, t)
        # print(index)
        return self.vote_stats[index][1]

def find_last_less_or_equals_position(stats, n):
    left = 0
    right = len(stats) - 1
    while left + 1 < right:
        mid = (left + right) // 2
        if n >= stats[mid][0]:
            left = mid
        else:
            right = mid
    if stats[right][0] <= n:
        return right
    if stats[left][0] <= n:
        return left 
    return -1

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
