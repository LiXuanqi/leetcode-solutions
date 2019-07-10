class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = readVersion(version1)
        v2 = readVersion(version2)
        for i in range(4):
            if v1[i] > v2[i]:
                return 1
            elif v1[i] < v2[i]:
                return -1
        return 0
        
def readVersion(version):
    args = version.split('.')
    ans = []
    for i in range(4):
        if i < len(args):
            ans.append(int(args[i]))
        else:
            ans.append(0)
    return ans