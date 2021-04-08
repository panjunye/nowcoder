package nowcoder.huawei;

import nowcoder.CaseRunner;

import java.util.Scanner;

/**
 * 有一种简易压缩算法：针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。
 * 例如：字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”。
 * 请您编写一个unzip函数，根据输入的字符串，判断其是否为合法压缩过的字符串，若输入合法则输出解压缩后的字符串，
 * 否则输出字符串“!error”来报告错误。
 */
public class R3 {
    public static void main(String[] args) {
        new CaseRunner().run(R3.class);
    }

    public static class Solution {
        public void run() {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case

            }
        }
    }
}

