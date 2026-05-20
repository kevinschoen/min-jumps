import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> indicesByValue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indicesByValue
                    .computeIfAbsent(arr[i], k -> new ArrayList<>())
                    .add(i);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == n - 1) {
                return dist[i];
            }

            if (i + 1 < n && dist[i + 1] == -1) {
                dist[i + 1] = dist[i] + 1;
                queue.add(i + 1);
            }
            if (i - 1 >= 0 && dist[i - 1] == -1) {
                dist[i - 1] = dist[i] + 1;
                queue.add(i - 1);
            }

            List<Integer> sameValue = indicesByValue.remove(arr[i]);
            if (sameValue != null) {
                for (int j : sameValue) {
                    if (dist[j] == -1) {
                        dist[j] = dist[i] + 1;
                        queue.add(j);
                    }
                }
            }
        }
        return -1;
    }
}
