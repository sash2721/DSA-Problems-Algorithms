## Problems Classification

```text
RECURSION & BACKTRACKING
│
├── 1. Basic / State-Carrying Recursion
│   ├── String to Integer (atoi)
│   ├── Pow(x, n)
│   └── Count Good Numbers
│
├── 2. Recursion Returning Information
│   ├── Count Subsequences with Sum K
│   └── Check Subsequence with Sum K
│
├── 3. Pick / Not-Pick
│   ├── Power Set / Subsequences
│   ├── Subset Sum I
│   ├── Count Subsequences with Sum K
│   └── Check Subsequence with Sum K
│
├── 4. Recursion + Reconstruction
│   ├── Sort a Stack
│   └── Reverse a Stack
│
├── 5. Constraint-Based Backtracking
│   ├── Generate Binary Strings
│   └── Generate Parentheses
│
├── 6. Combination Backtracking
│   ├── Combination Sum I
│   ├── Combination Sum II
│   └── Combination Sum III
│
├── 7. Duplicate-Aware Backtracking
│   ├── Combination Sum II
│   └── Subset Sum II
│
└── 8. Multiple Choices Per Level
    └── Letter Combinations of Phone Number
```

## Quick Revision Patterns

1. Pick / Not-Pick
   → Binary decision tree
   → Pick the element OR don't pick it

2. Loop + Backtracking
   → Multiple choices at every level
   → Choose → Recurse → Undo

3. Reuse Current Choice
   → recurse(i)

4. Don't Reuse Current Choice
   → recurse(i + 1)

5. Duplicate Handling
   → Sort first
   → if(i > idx && arr[i] == arr[i-1]) continue;

6. Recursion Return Type
   → Count  : pick + notPick
   → Exists : pick || notPick
   → Min    : min(pick, notPick)
   → Max    : max(pick, notPick)

7. State
   → Ask: "What information defines my current subproblem?"
   → index, sum, open/close, selected count, StringBuilder, etc.