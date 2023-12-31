class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = re.sub(r'[^\w]',' ',paragraph) 
        paragraph = paragraph.lower().split()
        paragraph = [word for word in paragraph if word not in banned]
        return collections.Counter(paragraph).most_common(1)[0][0]