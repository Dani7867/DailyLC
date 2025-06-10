class Solution:
    def maxDifference(self, s: str) -> int:
        freq = Counter(s)
        even = float('inf')
        odd = 0
        for i in freq.values():
            if i%2 == 0 and i!=0:
                even = min(even,i)
            else:
                odd = max(odd,i)

        return odd - even
        