import java.util.*;

class Solution {
    static public int[] maxToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int temp = -1;

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if(!st.isEmpty()) {
                ans[i] = Math.max(temp, st.peek());
            } else {
                ans[i] = Math.max(temp, arr[i]);
            }
            temp = ans[i];

            st.push(arr[i]);
        }

        return ans;
    }

    static public int[] maxToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int temp = -1;

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if(!st.isEmpty()) {
                ans[i] = Math.max(temp, st.peek());
            } else {
                ans[i] = Math.max(temp, arr[i]);
            }
            temp = ans[i];

            st.push(arr[i]);
        }

        return ans;
    }

    public static int trappingRainwater(int[] arr) {
        int[] maxRight = maxToRight(arr);
        int[] maxLeft = maxToLeft(arr);

        int sum = 0;
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            ans[i] = Math.min(maxRight[i], maxLeft[i]) - arr[i];
            sum += ans[i];
        }

        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        int ans = Solution.trappingRainwater(arr);

        System.out.print(ans + " ");
    }
}