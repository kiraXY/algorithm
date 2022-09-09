package datastructure.search.half;



/**
 * Created by wangning on 17/2/7.
 */
public class HalfSearchTest {

    
    public void test() {

        int[] arr = {1, 2, 15, 20, 26, 27, 28, 30, 45, 55, 60, 66, 72, 77, 80, 88, 99};
        int key = 1;

        int result = HalfSearch.halfSearch(arr, 0, arr.length -1, key);

        System.out.println(result);

    }


    
    public void test2() {
        int[] arr = {1, 2, 15, 20, 26, 27, 28, 30, 45, 55, 60, 66, 72, 77, 80, 88, 99, 106};
        int key = -10;

        int result = HalfSearch.halfSearchRecursion(arr, 0, arr.length -1, key, 0);

        System.out.println(result);
    }
}
