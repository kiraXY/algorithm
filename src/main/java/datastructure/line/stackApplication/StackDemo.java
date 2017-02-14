package datastructure.line.stackApplication;



import java.util.Stack;

/**
 * Created by wangning on 16/8/18.
 *
 * 利用双栈解释 表达式
 *
 * 将运算符压入 ops 中
 * 将值压入 vals 中
 * 遇到 ")" 弹出一个运算符 并 弹出两个值计算后重新压入 vals 中
 */
public class StackDemo {

    public static void main(String[] args) {

        // 保存运算符
        Stack<String> ops = new Stack<String>();
        // 保留数字
        Stack<Double> vals = new Stack<Double>();


        String str = "(1+((2+2)*(4*5)))";

        String[] arr = str.split("");

        for (String x : arr) {
            if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("%")) { // 运算符入栈操作
                ops.push(x);
            } else if(x.matches("\\d*") || x.matches("\\d+\\.\\d*")) {  // 值入栈操作
                vals.push(Double.parseDouble(x));
            } else if(x.equals(")")) {  // 计算操作
                Double a = vals.pop();
                String op = ops.pop();
                if("+".equals(op)) vals.push(a + vals.pop());
                else if("-".equals(op)) vals.push(a - vals.pop());
                else if("*".equals(op)) vals.push(a * vals.pop());
                else if("/".equals(op)) vals.push(a / vals.pop());
                else if("%".equals(op)) vals.push(a % vals.pop());
            }
        }
        System.out.println(1+((2+2)*(4*5)));
        System.out.println(vals.pop());


    }

}
