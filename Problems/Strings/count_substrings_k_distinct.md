## Title
**Count Number of Substrings**

### Problem Statement
You are given a string s and a positive integer k.
Return the number of substrings that contain exactly k distinct characters.

### Examples
```
Example 1:
Input:
 s = "pqpqs", k = 2  
Output:
 7  
Explanation:
  All substrings with exactly 2 distinct characters:  
"pq", "pqp", "pqpq", "qp", "qpq", "pqs", "qs"  
Total = 7.

Example 2:
Input:
 s = "abcbaa", k = 3  
Output:
 5  
Explanation:
  All substrings with exactly 3 distinct characters:  
"abc", "abcb", "abcba", "bcba", "cbaa"  
Total = 5.
```

### Approach
Use sliding window approach and maintain a frequency map to track the distinct characters.