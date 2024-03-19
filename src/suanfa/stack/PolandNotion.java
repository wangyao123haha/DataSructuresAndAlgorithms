package suanfa.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description 逆波兰表达式
 * @Author wangyao
 * @Data 2024/3/19 21:37
 */

public class PolandNotion {

    public static void main(String[] args) {
        // 定义波兰表达式
        String expression = "3 4 + 5 * 6 -";
        System.out.println(calculate(getListString(expression)));
    }

    // 将数据和运算符放入list
    public static List<String> getListString(String e) {
        String[] s = e.split(" ");
        return Arrays.asList(s);
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        list.forEach(x -> {
            if (x.matches("\\d+")) {
                // 数字入栈
                stack.push(x);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (x.equals("+")) {
                    res = num1 + num2;
                } else if (x.equals("-")) {
                    res = num1 - num2;
                } else if (x.equals("*")) {
                    res = num1 * num2;
                } else if (x.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException();
                }
                stack.push(res + "");
            }
        });
        return Integer.parseInt(stack.pop());
    }
}
