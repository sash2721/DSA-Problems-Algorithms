import java.util.*;

class Solution {
    public static int[] solve(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek() > 0 && arr[i] < 0) {
                int sum = st.peek() + arr[i];

                if(sum == 0) { // if both asteroids are equal sized remove both
                    st.pop();
                    arr[i] = 0;
                } else if(sum < 0) { // remove the positive one from stack
                    st.pop();
                } else if(sum > 0) { // remove the negative one from list
                    arr[i] = 0;
                }
            }
            if(arr[i] == 0) continue;
            st.push(arr[i]);
        }

        int size = st.size();
        int[] ans = new int[size];
        for(int i = size-1; i >= 0; i--) {
            int val = st.peek();
            ans[i] = val;
            st.pop();
        }

        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = {3,5,-6,2,-1,4};
        int[] ans = Solution.solve(arr);

        for(int i: ans) {
            System.out.print(i + " ");
        }
    }
}