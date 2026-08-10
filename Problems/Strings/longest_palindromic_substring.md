## Title
Longest Palindromic Substring

## Problem Statement
In the given `String s` find the longest substring, which is a palindrome.

## Examples 
```
Example 1
Input:
 s = 'babad'
Output:
 bab (also can be aba)
Explanation:
 'bab' is a part of the string 'babad' and it is also a palindrome. Same can be the case for 'aba'

Example 2
Input:
 s = 'level'
Output:
 level
Explanation:
 'level' as a complete string is a substring of itself as well as its also a palindrome.
```

### Approach
Consider every letter in the given string as a central element of the palindrome and spread left and right to check its length as a palindrome.

### Problem Link
[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)