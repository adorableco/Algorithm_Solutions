class TrieNode:
    def __init__(self):
        self.word = False
        self.children = collections.defaultdict(TrieNode)

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        
        for w in word:
                node = node.children[w]
        
        node.word = True
        

    def search(self, word: str) -> bool:
        
        node = self.root

        for w in word:
            if w not in node.children:
                return False
            
            node = node.children[w]
        
        return node.word

    def startsWith(self, prefix: str) -> bool:
        
        node = self.root
        
        for p in prefix:
            if p not in node.children:
                return False
            
            node = node.children[p]
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)