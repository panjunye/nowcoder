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
                    Card card = new Card(rank, suit);
                    cards.add(card);
                }
                cards.sort(Comparator.comparingInt(o -> o.point));
                System.out.println(getHandType(cards));
                cards.clear();
            }
        }

        private int getHandType(List<Card> cards) {
            if (isStraightFlush(cards)) {
                return 1;
            }
            if (isFourOfKind(cards)) {
                return 2;
            }
            if (isFullHouse(cards)) {
                return 3;
            }
            if (isFlush(cards)) {
                return 4;
            }
            if (isStraight(cards)) {
                return 5;
            }
            if (isThreeOfKind(cards)) {
                return 6;
            }
            return 7;
        }

        private boolean isThreeOfKind(List<Card> cards) {
            return (isSameOfKind(cards, 0, 2) && !isPair(cards, 3, 4))
                    || (isSameOfKind(cards, 1, 3) && !isPair(cards, 0, 4))
                    || (isSameOfKind(cards, 2, 4) && !isPair(cards, 0, 1));
        }

        private boolean isFullHouse(List<Card> cards) {
            return isSameOfKind(cards, 0, 2) && isPair(cards, 3, 4)
                    || isPair(cards, 0, 1) && isSameOfKind(cards, 2, 4);
        }

        private boolean isPair(List<Card> cards, int p, int q) {
            return cards.get(p).point == cards.get(q).point;
        }

        private boolean isSameOfKind(List<Card> cards, int from, int to) {
            for (int i = from + 1; i <= to; ++i) {
                if (!isPair(cards, i, i - 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isFourOfKind(List<Card> cards) {
            return isSameOfKind(cards, 0, 3) || isSameOfKind(cards, 1, 4);
        }

        private boolean isStraightFlush(List<Card> cards) {
            return isStraight(cards) && isFlush(cards);
        }

        private boolean isFlush(List<Card> cards) {
            for (int i = 1; i < cards.size(); ++i) {
                if (!cards.get(i).suit.equals(cards.get(i - 1).suit)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isStraight(List<Card> cards) {
            boolean isStraight = true;
            for (int i = 1; i < cards.size(); i++) {
                if (cards.get(i).point - cards.get(i - 1).point != 1) {
                    isStraight = false;
                    break;
                }
            }
            if (!isStraight) {
                for (int i = 1; i < cards.size(); ++i) {
                    if (((cards.get((i + 1) % 5).point + 13) - cards.get(i).point) % 13 != 1) {
                        return false;
                    }
                }
            }
            return true;
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

