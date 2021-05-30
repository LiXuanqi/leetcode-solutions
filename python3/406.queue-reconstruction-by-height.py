class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        height_to_people = collections.defaultdict(list)
        for person in people:
            height_to_people[person[0]].append(person[1])
        
        ans = []
        
        for height in reversed(sorted(height_to_people.keys())):
            candidates = sorted(height_to_people[height])
            for v in candidates:
                ans.insert(v, (height, v))
        return ans
        
        
        
