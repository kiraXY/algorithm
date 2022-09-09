import java.util.Deque;
import java.util.LinkedList;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int [] arr= new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(arr, k);
        System.out.println();
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] a, int k) {
        //队列里存放数组的下标
        Deque<Integer> deque = new LinkedList<>();
        int result [] = new int[a.length-k+1];
        for (int i = 0; i < a.length; i++) {
            while (!deque.isEmpty() && a[deque.getLast().intValue()]<a[i]){
                deque.removeLast();
            }
            deque.add(i);

            if(deque.getFirst()<i-k+1){
                deque.removeFirst();
            }
            if(i+1>=k) {
                result[i - k + 1]=a[deque.getFirst().intValue()];
            }
        }

        return result;
    }
}
