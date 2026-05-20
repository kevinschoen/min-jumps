# min-jumps

Minimum jumps to reach the last index of an array (LeetCode-style problem).

Given an array where you can jump to index ±1 or to any index with the same value, return the minimum number of jumps to reach the last index. Return `-1` if unreachable.

## Solution

BFS over indices, with a value → indices map to visit all same-value positions in one step. Same-value edges are consumed once per value to avoid redundant work.

## Run tests

```bash
javac Solution.java SolutionTest.java && java SolutionTest
```

Expected output: `All tests passed.`
