import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = (long) times[0] * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}