import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            deque.addLast(arr[i]);
            set.add(arr[i]);

            // Keep window size equal to m
            if (deque.size() > m) {
                int removed = deque.removeFirst();

                // Remove from set only if it no longer exists
                // in the current window
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }

            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, set.size());
            }
        }

        System.out.println(maxUnique);

        sc.close();
    }
}


Input (stdin)
6 3
5 3 5 2 3 2
Your Output (stdout)
3
