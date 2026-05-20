public class SolutionTest {
    static void check(int[] arr, int expected) {
        int actual = new Solution().minJumps(arr);
        if (actual != expected) {
            throw new AssertionError("expected " + expected + ", got " + actual);
        }
    }

    public static void main(String[] args) {
        check(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}, 3);
        check(new int[] {7}, 0);
        check(new int[] {7, 6, 9, 6, 9, 6, 9, 7}, 1);

        System.out.println("All tests passed.");
    }
}
