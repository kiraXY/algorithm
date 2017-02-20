package datastructure.line2.example;

import datastructure.line2.Stack.Stack;
import datastructure.line2.Stack.StackSLinked.StackSLinked;

/**
 * Created by wangning on 2017/2/17.
 */
public class bracketMatch {
    public static void main(String[] args) {
        boolean result = bracketMatch("()");
        System.out.println(result);
    }

    public static boolean bracketMatch(String str) {
        Stack s = new StackSLinked();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    s.push(Integer.valueOf(c));
                    break;
                case '}':
                    if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '{') break;
                    else return false;
                case ']':
                    if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '[') break;
                    else return false;
                case ')':
                    if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '(') break;
                    else return false;
            }
        }
        if (s.isEmpty()) return true;
        else return false;
    }

}
