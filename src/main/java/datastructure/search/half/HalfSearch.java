package datastructure.search.half;

/**
 * Created by wangning on 17/2/7.
 */
public class HalfSearch {

    /**
     * 非递归折半查找
     * @param arr
     * @param lo
     * @param hi
     * @param key
     */
    public static int halfSearch(int[] arr, int lo, int hi, int key) {

        int num = 0;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(key == arr[mid]) {
                return arr[mid];

            } else if(key < arr[mid]) {
                hi = mid - 1;

            } else if(key > arr[mid]) {
                lo = mid + 1;
            }

            System.out.println("第" + ++num + "次查找");
        }

        return -1;
    }


    public static int halfSearchRecursion(int[] arr, int lo, int hi, int key, int searchNum) {

        int mid = (lo + hi) / 2;

        if(arr[mid] == key) {
            return arr[mid];
        } else if(key < arr[mid]) {
            hi = mid - 1;

        } else if(key > arr[mid]) {
            lo = mid + 1;
        }

        if(lo > hi) {
            return -1;
        }

        System.out.println("第" + ++searchNum + "次查找");

        return halfSearchRecursion(arr, lo, hi, key, searchNum);

    }
}
