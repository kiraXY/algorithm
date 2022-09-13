public class reversePairsTT {
    /**
     * 终止条件： 当 l \geq rl≥r 时，代表子数组长度为 1 ，此时终止划分；
     * 递归划分： 计算数组中点 mm ，递归划分左子数组 merge_sort(l, m) 和右子数组 merge_sort(m + 1, r) ；
     * 合并与逆序对统计：
     * 暂存数组 numsnums 闭区间 [i, r][i,r] 内的元素至辅助数组 tmptmp ；
     * 循环合并： 设置双指针 ii , jj 分别指向左 / 右子数组的首元素；
     * 当 i = m + 1i=m+1 时： 代表左子数组已合并完，因此添加右子数组当前元素 tmp[j]tmp[j] ，并执行 j = j + 1j=j+1 ；
     * 否则，当 j = r + 1j=r+1 时： 代表右子数组已合并完，因此添加左子数组当前元素 tmp[i]tmp[i] ，并执行 i = i + 1i=i+1 ；
     * 否则，当 tmp[i] \leq tmp[j]tmp[i]≤tmp[j] 时： 添加左子数组当前元素 tmp[i]tmp[i] ，并执行 i = i + 1i=i+1；
     * 否则（即 tmp[i] > tmp[j]tmp[i]>tmp[j]）时： 添加右子数组当前元素 tmp[j]tmp[j] ，并执行 j = j + 1j=j+1 ；此时构成 m - i + 1m−i+1 个「逆序对」，统计添加至 resres ；
     * 返回值： 返回直至目前的逆序对总数 resres ；
     * <p>
     * 作者：jyd
     * 链接：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param args
     */

    public static void main(String[] args) {
        int a[] = new int[]{7, 5, 6, 4, 8, 3};
        int i = reversePairs(a);
        System.out.println(i);
    }

    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        //3 当拆分到数组只有一个元素的时候,不存在right>left的情况，直接return 0 结束递归。
        if (left == right) {
            return 0;
        }

        //1 首选做二分法拆分数组
        int mid = left + (right - left) / 2;
        //2 拆分左右数组
        int leftParis = reversePairs(nums, left, mid, temp);
        int rightParis = reversePairs(nums, mid + 1, right, temp);

        // 4 经过递归后左右数组都是递增数组 所以如果left的最后一个元素比 right的第一个元素大。
        //   则在当前合并时不存在right元素大于left元素的情况
        if (nums[mid] <= nums[mid + 1]) {
            return leftParis + rightParis;
        }

        // 5存在right元素大于left元素的情况
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftParis + rightParis + crossPairs;

    }

    public static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // 暂存数组 numsnums 闭区间 [i, r][i,r] 内的元素至辅助数组 tmp
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // left数组开始位置
        int i = left;
        // right数组开始位置
        int j = mid + 1;

        // right>left数量
        int count = 0;

        for (int k = 0; k < right; k++) {
            // i==mid+1 代表left数组已经合并完，right数组依次添加
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            }
            // k==right+1 代表right数组已经合并完，left数组依次添加

            if (k == right + 1) {
                nums[k] = temp[i];
                i++;
            }

            //
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }
            if (temp[i] > temp[j]) {
                nums[k] = temp[j];
                j++;
                count += mid + 1 - i;
            }
            return count;

        }


        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;

    }
}
