import java.util.Stack;

public class trap4222 {
    public static void main(String[] args) {

        int a[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(a);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
       int sum = 0;

       Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if(stack.empty()){

            }



        }


       return sum;

    }
/**
 * public static int trap(int[] height){
 * int sum=0;
 * int maxRight [] = new int[height.length];
 * int maxLeft [] = new int[height.length];
 * for (int i = 1; i < height.length-1; i++) {
 * maxLeft[i]=Math.max(maxLeft[i-1],height[i-1]);
 * }
 * <p>
 * for (int i = height.length-2; i >0; i--) {
 * maxRight[i]=Math.max(maxRight[i+1],height[i+1]);
 * }
 * <p>
 * for (int i = 0; i < height.length; i++) {
 * int min = Math.min(maxLeft[i], maxRight[i]);
 * if(min>height[i]){
 * sum+=(min-height[i]);
 * }
 * }
 * <p>
 * return sum;
 * }
 * <p>
 * public  static  int trap(int[] height) {
 * int result = 0;
 * if (height==null || height.length<1){
 * return 0;
 * }
 * int max = getMax(height);
 * for (int i = 0; i < max; i++) {
 * <p>
 * int tmp =0;
 * for (int j = 1; j < height.length+1; j++) {
 * if(height[j-1]-i >0){
 * if(tmp==0 ){
 * tmp=j;
 * continue;
 * }
 * if(j-tmp==1){
 * tmp=j;
 * continue;
 * }
 * result+=j-tmp-1;
 * tmp=j;
 * }
 * }
 * }
 * return result;
 * }
 * <p>
 * public static int getMax(int [] arr){
 * int max= 0;
 * for (int i : arr) {
 * if(i>max){
 * max=i;
 * }
 * }
 * return max;
 * }
 **/

/**
 public  static  int trap(int[] height) {
 int result = 0;
 if (height==null || height.length<1){
 return 0;
 }
 int max = getMax(height);
 for (int i = 0; i < max; i++) {

 int tmp =0;
 for (int j = 1; j < height.length+1; j++) {
 if(height[j-1]-i >0){
 if(tmp==0 ){
 tmp=j;
 continue;
 }
 if(j-tmp==1){
 tmp=j;
 continue;
 }
 result+=j-tmp-1;
 tmp=j;
 }
 }
 }
 return result;
 }

 public static int getMax(int [] arr){
 int max= 0;
 for (int i : arr) {
 if(i>max){
 max=i;
 }
 }
 return max;
 }
 **/
}
