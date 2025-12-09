 // Problem: Find the Closest Palindrome
 // Platform: LeetCode 
 // Time Complexity: O(n) 
 // Space Complexity: O(n) 


class Solution(object):
    def gen(self, p, even):
        s = str(p)
        if even:
            r = s
        else:
            r = s[:-1]
        return int(s + r[::-1])

    def nearestPalindromic(self, n):
        """
        :type n: str
        :rtype: str
        """
        if n == "1":
            return "0"

        num = int(n)
        l = len(n)
        p = int(n[: (l + 1) // 2])

        c = set([
            10**(l - 1) - 1,
            10**l + 1,
            self.gen(p - 1, l % 2 == 0),
            self.gen(p,     l % 2 == 0),
            self.gen(p + 1, l % 2 == 0)
        ])

        if num in c:
            c.remove(num)

        return str(min(c, key=lambda x: (abs(x - num), x)))
