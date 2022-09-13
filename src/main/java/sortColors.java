public class sortColors {

    public static void main(String[] args) {

        int a[] = new int[]{1, 2, 0};
        sortColors(a);
        System.out.println();
        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = findEnd(nums);
        int cur = 0;
        while (cur < nums.length && cur <= end) {
            int tmp = 0;

            while (nums[cur] == 2 && cur<end) {
                tmp = nums[end];
                nums[end] = nums[cur];
                nums[cur] = tmp;
                end--;
            }

            if (nums[cur] == 0) {
                tmp = nums[start];
                nums[start] = nums[cur];
                nums[cur] = tmp;
                start++;
            }

            cur++;
        }

    }

    public static int findEnd(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] != 2) {
                return i;
            }
        }
        return 0;
    }
}
