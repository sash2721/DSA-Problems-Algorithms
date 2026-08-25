import java.util.*;

class Solution {
    public static int[] NSL(int[] arr) {
        int n = arr.length;
        Stack<int[]> sLeft = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int count = 1;
            while(!sLeft.isEmpty() && sLeft.peek()[0] > arr[i]) {
                count += sLeft.peek()[1];
                sLeft.pop();
            }

            sLeft.push(new int[]{arr[i], count});
            ans[i] = count;
        }

        return ans;
    }

    public static int[] NSR(int[] arr) {
        int n = arr.length;
        Stack<int[]> sRight = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--) {
            int count = 1;
            while(!sRight.isEmpty() && sRight.peek()[0] >= arr[i]) {
                count += sRight.peek()[1];
                sRight.pop();
            }

            sRight.push(new int[]{arr[i], count});
            ans[i] = count;
        }

        return ans;
    }

    public static int solve(int[] arr) {
        int n = arr.length;
        int[] left = NSL(arr);
        int[] right = NSR(arr);

        int modval = (int)1e9 + 7;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            long contribution = ((long)arr[i] * left[i] * right[i]) % modval;

            ans = (ans + contribution) % modval;
        }
        return (int)ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        int ans = Solution.solve(arr);

        System.out.println(ans);
    }
}