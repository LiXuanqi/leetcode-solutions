class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        if not paths:
            return []
        
        def decodePath(path, contentToPaths):
            args = path.split(" ")
            folderPath = args[0]
            for i in range(1, len(args)):
                file = args[i]
                leftParenthese = file.index("(")
                filename = file[:leftParenthese]
                content = file[leftParenthese + 1 : -1]
                contentToPaths.setdefault(content, []).append(folderPath + "/" + filename)   
        contentToPaths = {}
        for path in paths:
            decodePath(path, contentToPaths)
        return list([value for value in contentToPaths.values() if len(value) > 1])