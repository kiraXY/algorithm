package datastructure.recursive;

/**
 * 汉诺塔 （河内塔）问题
 * 
 * 从上到下 小到大的盘子移动问题 一次只能移动一个 三个柱子
 * 
 * 
 * @author wangning
 *
 */
public class HanoiTower {

    /**
     * 
     * 通过递归不停的切换 A B C 三塔切换盘子
     * 
     * @param topN 移动盘子的个数
     * @param A 要移动盘子的塔座 A
     * @param B 中间塔座 B
     * @param C 目标塔座 C
     */
    public static void doTower(int topN, char A, char B, char C) {

        if (topN == 1) {
            System.out.println("盘子1从" + A + "塔座移动到" + C + "塔座");
        } else {

            // 将最大盘子之外的 从A 移动到 B
            doTower(topN - 1, A, C, B);

            // 将最大盘子从A 移动到 C
            System.out.println("盘子" + topN + "从" + A + "塔座移动到" + C + "塔座");

            // 将倒数第二大的盘子 从 B 移动到 C
            doTower(topN - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        doTower(3, 'A', 'B', 'C');
    }

}
