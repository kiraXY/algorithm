package datastructure.line2;

import java.util.Stack;

public class dailyTemperatures {

    public static void main(String[] args) {
        int [] a= new int []{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(a);
        System.out.println();
        System.out.println();
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        // 构建一个栈,用来存放每日温度的下标
        Stack<Integer> stack = new Stack<>();

        // 构建一个数组，用来保存输出结果
        int[] res = new int[temperatures.length];

        // 从头开始遍历每天的温度
        for (int i = 0; i < temperatures.length; i++) {

            // 拿到当天的温度，需要和栈首元素进行比较
            // 如果此时栈不为空并且当天的温度大于栈首元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                // 首先获取栈首元素的值，并将元素从栈中移除
                int preIndex = stack.pop();

                // 它们的下标差就是栈首元素等了多少天等到的更高温度的结果，保存到输出数组 res 中
                res[preIndex] = i - preIndex;
            }

            // 再把当天的温度的下标值存放到栈中
            stack.push(i);
        }
        // 最后输出 res 数组即可
        return res;
    }
}
