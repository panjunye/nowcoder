package nowcoder.huawei;


import nowcoder.CaseRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * LISP语言唯一的语法就是括号要配对。
 * 形如 (OP P1 P2 ...)，括号内元素由单个空格分割。
 * 其中第一个元素OP为操作符，后续元素均为其参数，参数个数取决于操作符类型
 * 注意：参数 P1, P2 也有可能是另外一个嵌套的 (OP P1 P2 ...)
 * 当前OP类型为 add / sub / mul / div（全小写），分别代表整数的加减乘除法
 * 简单起见，所有 OP 参数个数均为 2
 * 举例:
 * - 输入：(mul 3 -7) 输出：-21
 * - 输入：(add 1 2) 输出：3
 * - 输入：(sub (mul 2 4) (div 9 3)) 输出：5
 * - 输入：(div 1 0) 输出：error
 * 题目涉及数字均为整数，可能为负；不考虑32位溢出翻转。
 * 除零错误时，输出 "error"，除法遇除不尽，取整，即 3/2 = 1
 */
public class R1 {
    public static void main(String[] args) {
        new CaseRunner().run(R1.class);
    }

    public static class Solution {
        public void run() {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                String input = in.nextLine();
                List<Object> tokenizerResult = tokenizer(input);
                System.out.println(tokenizerResult);
            }
        }

        private List<Object> tokenizer(String input) {
            if (input == null || input.isEmpty()) {
                return Collections.emptyList();
            }
            List<Object> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(input.charAt(0));
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                char fc = sb.length() > 0 ? sb.charAt(0) : 0;
                if (fc == ' ') {
                    clear(sb);
                    sb.append(c);
                } else if (fc >= 'a' && fc <= 'z') {
                    if (c >= 'a' && c <= 'z') {
                        sb.append(c);
                    } else {
                        result.add(sb.toString());
                        clear(sb);
                        sb.append(c);
                    }
                } else if (fc == '-' || (fc >= '0' && fc <= '9')) {
                    if (c >= '0' && c <= '9') {
                        sb.append(c);
                    } else {
                        result.add(Integer.parseInt(sb.toString()));
                        clear(sb);
                        sb.append(c);
                    }
                }else if(fc == '(' || fc == ')'){
                    result.add(sb.toString());
                    clear(sb);
                    sb.append(c);
                }
            }
            return result;
        }

        private void clear(StringBuilder sb) {
            sb.delete(0, sb.length());
        }
    }
}
