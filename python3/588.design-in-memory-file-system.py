FOLDER = 0
FILE = 1

class FileNode:
    def __init__(self, type):
        self.type = type
        self.content = ''
        self.children = {}
        
class FileSystem:

    def __init__(self):
        self.root = FileNode(FOLDER)
    
        

    def ls(self, path: str) -> List[str]:
        curr = self.root
        names = path.split('/')[1:]
        for name in names:
            if name == '':
                continue
            curr = curr.children[name]
        if curr.type == FILE:
            return [names[-1]]
        else:
            return list(sorted(curr.children.keys()))
        

    def mkdir(self, path: str) -> None:
        curr = self.root
        for name in path.split('/')[1:]:
            if name not in curr.children:
                curr.children[name] = FileNode(FOLDER)
            curr = curr.children[name]
            

    def addContentToFile(self, filePath: str, content: str) -> None:
        curr = self.root
        for name in filePath.split('/')[1:]:
            if name not in curr.children:
                curr.children[name] = FileNode(FOLDER)
            curr = curr.children[name]
            
        curr.type = FILE
        curr.content += content
        

    def readContentFromFile(self, filePath: str) -> str:
        curr = self.root
        for name in filePath.split('/')[1:]:
            curr = curr.children[name]
        return curr.content


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.ls(path)
# obj.mkdir(path)
# obj.addContentToFile(filePath,content)
# param_4 = obj.readContentFromFile(filePath)
