import java.util.*;

/**
 * ArrayConcepts: DSA Array Concepts in Java
 *
 * This file demonstrates all important array-related algorithms and concepts for DSA.
 * Topics covered:
 * 1. Find Minimum and Maximum
 * 2. Reverse Array
 * 3. Binary Search (Iterative & Recursive)
 * 4. Find Kth Largest/Smallest
 * 5. Two Sum
 * 6. Move Zeroes to End
 * 7. Remove Duplicates from Sorted Array
 * 8. Rotate Array
 * 9. Kadane's Algorithm (Maximum Subarray Sum)
 * 10. Prefix Sum
 * 11. Merge Intervals
 * 12. Product of Array Except Self
 * 13. Majority Element (Boyer-Moore)
 * 14. Next Permutation
 * 15. Subarray Sum Equals K
 * 16. Find Missing Number
 * 17. Find Duplicate Number
 * 18. Trapping Rain Water
 * 19. Longest Consecutive Sequence
 * 20. Sliding Window Maximum
 */

public class ArrayConcepts {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] sortedArr = {1, 2, 2, 3, 4, 5, 5, 6, 9};
        int[] arrWithZeroes = {0, 1, 0, 3, 12};
        int[] arrForRotation = {1, 2, 3, 4, 5, 6, 7};
        int[] arrForIntervals = {1, 3, 2, 6, 8, 10, 15, 18};
        int[] arrForProduct = {1, 2, 3, 4};
        int[] arrForMajority = {2, 2, 1, 1, 1, 2, 2};
        int[] arrForPermutation = {1, 2, 3};
        int[] arrForSumK = {1, 2, 3};
        int[] arrForMissing = {3, 0, 1};
        int[] arrForDuplicate = {1, 3, 4, 2, 2};
        int[] arrForRain = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arrForConsecutive = {100, 4, 200, 1, 3, 2};
        int[] arrForSliding = {1,3,-1,-3,5,3,6,7};

        // 1. Find Min and Max
        System.out.println("Min: " + findMin(arr) + ", Max: " + findMax(arr));

        // 2. Reverse Array
        System.out.println("Reverse: " + Arrays.toString(reverseArray(arr.clone())));

        // 3. Binary Search
        System.out.println("Binary search 5: " + binarySearch(sortedArr, 5));

        // 4. Kth Largest/Smallest
        System.out.println("2nd largest: " + kthLargest(arr.clone(), 2));
        System.out.println("3rd smallest: " + kthSmallest(arr.clone(), 3));

        // 5. Two Sum
        System.out.println("Two sum (target 8): " + Arrays.toString(twoSum(arr, 8)));

        // 6. Move Zeroes
        System.out.println("Move zeroes: " + Arrays.toString(moveZeroes(arrWithZeroes.clone())));

        // 7. Remove Duplicates from Sorted Array
        System.out.println("Remove duplicates: " + removeDuplicatesSorted(sortedArr.clone()));

        // 8. Rotate Array
        System.out.println("Rotate by 3: " + Arrays.toString(rotateArray(arrForRotation.clone(), 3)));

        // 9. Kadane's Algorithm
        System.out.println("Max subarray sum: " + maxSubArray(arr));

        // 10. Prefix Sum
        System.out.println("Prefix sum: " + Arrays.toString(prefixSum(arr)));

        // 11. Merge Intervals
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merged intervals: " + Arrays.deepToString(mergeIntervals(intervals)));

        // 12. Product of Array Except Self
        System.out.println("Product except self: " + Arrays.toString(productExceptSelf(arrForProduct)));

        // 13. Majority Element
        System.out.println("Majority element: " + majorityElement(arrForMajority));

        // 14. Next Permutation
        nextPermutation(arrForPermutation);
        System.out.println("Next permutation: " + Arrays.toString(arrForPermutation));

        // 15. Subarray Sum Equals K
        System.out.println("Subarray sum equals 3: " + subarraySum(arrForSumK, 3));

        // 16. Find Missing Number
        System.out.println("Missing number: " + missingNumber(arrForMissing));

        // 17. Find Duplicate Number
        System.out.println("Duplicate number: " + findDuplicate(arrForDuplicate));

        // 18. Trapping Rain Water
        System.out.println("Trapped rain water: " + trap(arrForRain));

        // 19. Longest Consecutive Sequence
        System.out.println("Longest consecutive sequence: " + longestConsecutive(arrForConsecutive));

        // 20. Sliding Window Maximum (k=3)
        System.out.println("Sliding window max: " + Arrays.toString(maxSlidingWindow(arrForSliding, 3)));
    }

    // 1. Find Minimum
    static int findMin(int[] arr) {
        int min = arr[0];
        for (int n : arr) min = Math.min(min, n);
        return min;
    }

    // 1. Find Maximum
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) max = Math.max(max, n);
        return max;
    }

    // 2. Reverse Array
    static int[] reverseArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l]; arr[l] = arr[r]; arr[r] = tmp;
            l++; r--;
        }
        return arr;
    }

    // 3. Binary Search (Iterative)
    static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) return m;
            if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    // 4. Kth Largest (Quickselect)
    static int kthLargest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    // 4. Kth Smallest (Quickselect)
    static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    static int quickSelect(int[] arr, int l, int r, int k) {
        if (l == r) return arr[l];
        int pivot = arr[r], p = l;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                int tmp = arr[i]; arr[i] = arr[p]; arr[p] = tmp; p++;
            }
        }
        int tmp = arr[p]; arr[p] = arr[r]; arr[r] = tmp;
        if (k == p) return arr[p];
        else if (k < p) return quickSelect(arr, l, p - 1, k);
        else return quickSelect(arr, p + 1, r, k);
    }

    // 5. Two Sum (HashMap)
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(arr[i], i);
        }
        return new int[0];
    }

    // 6. Move Zeroes to End
    static int[] moveZeroes(int[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) arr[idx++] = arr[i];
        }
        while (idx < arr.length) arr[idx++] = 0;
        return arr;
    }

    // 7. Remove Duplicates from Sorted Array
    static int removeDuplicatesSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int idx = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) arr[idx++] = arr[i];
        }
        return idx;
    }

    // 8. Rotate Array (Reverse)
    static int[] rotateArray(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        return arr;
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l]; arr[l] = arr[r]; arr[r] = tmp;
            l++; r--;
        }
    }

    // 9. Kadane's Algorithm (Maximum Subarray Sum)
    static int maxSubArray(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // 10. Prefix Sum
    static int[] prefixSum(int[] arr) {
        int[] ps = new int[arr.length];
        ps[0] = arr[0];
        for (int i = 1; i < arr.length; i++) ps[i] = ps[i - 1] + arr[i];
        return ps;
    }

    // 11. Merge Intervals
    static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) curr[1] = Math.max(curr[1], intervals[i][1]);
            else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }

    // 12. Product of Array Except Self (O(n), no division)
    static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= arr[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= arr[i];
        }
        return res;
    }

    // 13. Majority Element (Boyer-Moore)
    static int majorityElement(int[] arr) {
        int count = 0, candidate = 0;
        for (int n : arr) {
            if (count == 0) candidate = n;
            count += (n == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // 14. Next Permutation
    static void nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) j--;
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
        reverse(arr, i + 1, arr.length - 1);
    }

    // 15. Subarray Sum Equals K (HashMap, O(n))
    static int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int n : arr) {
            sum += n;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 16. Find Missing Number (0 to n)
    static int missingNumber(int[] arr) {
        int n = arr.length, total = n * (n + 1) / 2;
        for (int num : arr) total -= num;
        return total;
    }

    // 17. Find Duplicate Number (Floyd's Tortoise and Hare)
    static int findDuplicate(int[] arr) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    // 18. Trapping Rain Water (Two Pointers)
    static int trap(int[] height) {
        int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= leftMax) leftMax = height[l];
                else res += leftMax - height[l];
                l++;
            } else {
                if (height[r] >= rightMax) rightMax = height[r];
                else res += rightMax - height[r];
                r--;
            }
        }
        return res;
    }

    // 19. Longest Consecutive Sequence (O(n))
    static int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) set.add(n);
        int maxLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curr = n, len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    // 20. Sliding Window Maximum (Deque, O(n))
    static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = arr[dq.peekFirst()];
        }
        return res;
    }
}
