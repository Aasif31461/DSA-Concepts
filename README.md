# DSA Java Concepts Reference

This document lists all major DSA concepts implemented in the Java files of this workspace, with detailed examples and a table of contents for each file.

---

## Table of Contents

- [Prime.java](#primejava)
- [StringConcepts.java](#stringconceptsjava)
- [ArrayConcepts.java](#arrayconceptsjava)

---

## Prime.java

### Table of Contents
1. Basic Prime Check
2. Optimized Prime Check
3. Sieve of Eratosthenes
4. Count of Primes
5. Generate All Primes up to n
6. Prime Factorization

### Examples

```java
// 1. Basic Prime Check
System.out.println(Prime.isPrime(29)); // true

// 2. Optimized Prime Check
System.out.println(Prime.isPrimeOptimized(97)); // true

// 3. Sieve of Eratosthenes
System.out.println(Arrays.toString(Prime.sieveOfEratosthenes(30)));
// [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

// 4. Count of Primes
System.out.println(Prime.countPrimes(30)); // 10

// 5. Generate All Primes up to n
System.out.println(Arrays.toString(Prime.generatePrimes(20)));
// [2, 3, 5, 7, 11, 13, 17, 19]

// 6. Prime Factorization
System.out.println(Arrays.toString(Prime.primeFactors(84)));
// [2, 2, 3, 7]
```

---

## StringConcepts.java

### Table of Contents
1. Anagram Check (two ways)
2. Palindrome Check
3. String Reversal
4. Substring Search (Naive)
5. Character Frequency
6. Remove Duplicates from String
7. String to Integer (atoi)
8. Integer to String
9. Longest Common Prefix
10. String Rotation Check
11. Contains Duplicate in Array
12. Longest Substring Without Repeating Characters
13. Longest Palindromic Substring
14. Check if String is a Permutation of Another
15. String Compression
16. Edit Distance (Levenshtein)
17. Rabin-Karp Substring Search
18. Sliding Window Maximum

### Examples

```java
// 1. Anagram Check
System.out.println(isAnagramEffective("anagram", "nagaram")); // true
System.out.println(isAnagram("listen", "silent")); // true

// 2. Palindrome Check
System.out.println(isPalindrome("racecar")); // true

// 3. String Reversal
System.out.println(reverseString("hello")); // "olleh"

// 4. Substring Search
System.out.println(substringSearch("banana", "ana")); // 1

// 5. Character Frequency
System.out.println(charFrequency("hello world")); // {h=1, e=1, l=3, o=2,  =1, w=1, r=1, d=1}

// 6. Remove Duplicates
System.out.println(removeDuplicates("programming")); // "progamin"

// 7. String to Integer
System.out.println(stringToInt("-12345")); // -12345

// 8. Integer to String
System.out.println(intToString(-6789)); // "-6789"

// 9. Longest Common Prefix
System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"})); // "fl"

// 10. String Rotation
System.out.println(isRotation("waterbottle", "erbottlewat")); // true

// 11. Contains Duplicate in Array
System.out.println(containsDuplicateList(new int[]{1,2,3,4,4})); // true

// 12. Longest Substring Without Repeating Characters
System.out.println(longestSubstringWithoutRepeating("abcabcbb")); // 3

// 13. Longest Palindromic Substring
System.out.println(longestPalindromicSubstring("babad")); // "bab" or "aba"

// 14. Check if String is a Permutation of Another
System.out.println(isPermutation("abc", "cab")); // true

// 15. String Compression
System.out.println(compressString("aabcccccaaa")); // "a2b1c5a3"

// 16. Edit Distance
System.out.println(editDistance("kitten", "sitting")); // 3

// 17. Rabin-Karp Substring Search
System.out.println(rabinKarp("banana", "ana")); // 1

// 18. Sliding Window Maximum
System.out.println(Arrays.toString(slidingWindowMax("123459876", 3))); // [3, 4, 9, 9, 9, 9, 8]
```

---

## ArrayConcepts.java

### Table of Contents
1. Find Minimum and Maximum
2. Reverse Array
3. Binary Search (Iterative & Recursive)
4. Find Kth Largest/Smallest
5. Two Sum
6. Move Zeroes to End
7. Remove Duplicates from Sorted Array
8. Rotate Array
9. Kadane's Algorithm (Maximum Subarray Sum)
10. Prefix Sum
11. Merge Intervals
12. Product of Array Except Self
13. Majority Element (Boyer-Moore)
14. Next Permutation
15. Subarray Sum Equals K
16. Find Missing Number
17. Find Duplicate Number
18. Trapping Rain Water
19. Longest Consecutive Sequence
20. Sliding Window Maximum

### Examples

```java
// 1. Find Min and Max
System.out.println(findMin(arr)); // 1
System.out.println(findMax(arr)); // 9

// 2. Reverse Array
System.out.println(Arrays.toString(reverseArray(arr.clone()))); // [5, 6, 2, 9, 5, 1, 4, 1, 3]

// 3. Binary Search
System.out.println(binarySearch(sortedArr, 5)); // 5

// 4. Kth Largest/Smallest
System.out.println(kthLargest(arr.clone(), 2)); // 6
System.out.println(kthSmallest(arr.clone(), 3)); // 2

// 5. Two Sum
System.out.println(Arrays.toString(twoSum(arr, 8))); // [2, 4] (example)

// 6. Move Zeroes
System.out.println(Arrays.toString(moveZeroes(arrWithZeroes.clone()))); // [1, 3, 12, 0, 0]

// 7. Remove Duplicates from Sorted Array
System.out.println(removeDuplicatesSorted(sortedArr.clone())); // 6

// 8. Rotate Array
System.out.println(Arrays.toString(rotateArray(arrForRotation.clone(), 3))); // [5, 6, 7, 1, 2, 3, 4]

// 9. Kadane's Algorithm
System.out.println(maxSubArray(arr)); // 31

// 10. Prefix Sum
System.out.println(Arrays.toString(prefixSum(arr))); // [3, 4, 8, 9, 14, 23, 25, 31, 36]

// 11. Merge Intervals
int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
System.out.println(Arrays.deepToString(mergeIntervals(intervals))); // [[1, 6], [8, 10], [15, 18]]

// 12. Product of Array Except Self
System.out.println(Arrays.toString(productExceptSelf(arrForProduct))); // [24, 12, 8, 6]

// 13. Majority Element
System.out.println(majorityElement(arrForMajority)); // 2

// 14. Next Permutation
nextPermutation(arrForPermutation);
System.out.println(Arrays.toString(arrForPermutation)); // [1, 3, 2]

// 15. Subarray Sum Equals K
System.out.println(subarraySum(arrForSumK, 3)); // 2

// 16. Find Missing Number
System.out.println(missingNumber(arrForMissing)); // 2

// 17. Find Duplicate Number
System.out.println(findDuplicate(arrForDuplicate)); // 2

// 18. Trapping Rain Water
System.out.println(trap(arrForRain)); // 6

// 19. Longest Consecutive Sequence
System.out.println(longestConsecutive(arrForConsecutive)); // 4

// 20. Sliding Window Maximum
System.out.println(Arrays.toString(maxSlidingWindow(arrForSliding, 3))); // [3, 3, 5, 5, 6, 7]
```

---

> For more details, see the respective Java files in this workspace.
