package nowcoder.huawei;

import nowcoder.CaseRunner;

import java.util.*;

/**
 * 五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。
 * 判断牌型:
 * 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
 * 牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
 * 牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
 * 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
 * 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
 * 牌型6，三条：三张相同 + 两张单。
 * 牌型7，其他。
 * 说明：
 * 1）五张牌里不会出现牌大小和花色完全相同的牌。
 * 2）前面的牌型比后面的牌型大，如同花顺比四条大，依次类推。
 * 输入描述:
 * 输入由5行组成
 * 每行为一张牌大小和花色，牌大小为2~10、J、Q、K、A，花色分别用字符H、S、C、D表示红桃、黑桃、梅花、方块。
 * 输出描述:
 * 输出牌型序号，5张牌符合多种牌型时，取最大的牌型序号输出
 * <p>
 * 示例1
 * 输入：
 * 2 H
 * 3 C
 * 6 S
 * 5 S
 * 4 S
 * 输出：
 * 5
 */
public class R2 {
    public static void main(String[] args) {
        new CaseRunner().run(R2.class);
    }

    public static class Solution {
        public void run() {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            List<Card> cards = new ArrayList<>();
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                for (int i = 0; i < 5; i++) {
                    String rank = in.next();
                    String suit = in.next();
                    Card card = new Card(rank,suit);
                    cards.add(card);
                }
                System.out.println(cards);
            }
        }

        public static class Card {
            private static final Map<String, Integer> pointMap = new HashMap<>();

            static {
                for (int i = 2; i <= 10; i++) {
                    pointMap.put(i + "", i);
                }
                pointMap.put("A", 1);
                pointMap.put("J", 11);
                pointMap.put("Q", 12);
                pointMap.put("K", 13);
            }

            public final int point;
            public final String rank;
            public final String suit;

            public Card(String rank, String suit) {
                this.rank = rank;
                this.suit = suit;
                this.point = pointMap.get(rank);
            }
        }
    }
}

