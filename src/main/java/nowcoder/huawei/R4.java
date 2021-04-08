package nowcoder.huawei;

import nowcoder.CaseRunner;

import java.util.Scanner;

/**
 * 某个打印机根据打印队列执行打印任务。打印任务分为九个优先级，分别用数字1~9表示，数字越大优先级越高。
 * 打印机每次从队列头部取出第一个任务A，然后检查队列余下任务中有没有比A优先级更高的任务，如果有比A优先级高的任务，
 * 则将任务A放到队列尾部，否则就执行任务A的打印。请编写一个程序，根据输入的打印队列，输出实际的打印顺序
 * 输入描述：
 * 函数原型：void printOrder(const int input[], int len, int output[])
 * 输入参数input表示打印队列，为一个由整数1~9（优先级）组成的数组，数组索引0表示打印队列头部。
 * 对于C/C++，参数len表示input数组的长度。可以假定输入参数总是合法有效的，input数组长度有可能为0，但不会是空指针。
 * 输出描述：
 * 输出为一个表示实际打印顺序的数组，其数组项为打印任务在输入数组中的索引值（从0开始）。
 * Java通过返回值输出。C/C++通过输出参数output输出，可以假定为存放结果分配了足够的空间。
 * 示例1：
 * 输入
 * 9, 3, 5
 * 输出
 * 0, 2, 1
 */
public class R4 {
    public static void main(String[] args) {
        new CaseRunner().run(R4.class);
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

