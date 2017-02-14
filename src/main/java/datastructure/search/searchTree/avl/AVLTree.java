package datastructure.search.searchTree.avl;

import datastructure.search.searchTree.bst.BSTTree;
import datastructure.strategy.Strategy;
import datastructure.tree.binTree.BinTreeNode;

/**
 * Created by wangning on 17/2/12.
 *
 * AVL 树 -- > 自平衡二叉树
 * 二叉树的旋转 分为左右旋转
 *
 * 二叉树的平衡因子定义，设V为根，则对比V的左右子树高度差（空树为 -1）
 * 若V 的左右子树之差绝对值 均不超过1 ，则该树为AVL 树
 *
 * 数据结构定义如下
 *
 *              C
 *          B       T3
 *      A      T2
 *  T0    T1
 *
 *  对于二叉树而言， 以失衡节点C 为根是有以下定义:
 *      C 为 B 的父节点， B 为 A的父节点
 *      以C为root 的节点  那么 B是 C的较高的子树
 *      以B为root 的节点  那么 A是 B的较高的子树
 *
 *      B的兄弟 为 C的 子树（只有一个节点）并且B的兄弟是C的 较矮的子树
 *      A的兄弟 为 B的 子树（只有一个节点）并且B的兄弟是B的 较矮的子树
 *
 *  此时存在
 *      C B A 三个节点
 *      T0 T1 T2 T3 四课子树
 *
 * 二叉树的失衡分为四种情况（设C为失衡节点）
 * 由C 的左孩子为根时 左孩子的左子树过高
 * 由C 的右孩子为根时 右孩子的右子树过高
 * 由C 的左孩子为根时 左孩子的右子树过高
 * 由C 的右孩子为根时 右孩子的左子树过高
 *
 * 失衡的树 必然会有A、B、C 三个节点
 * 局部失衡的子树最后 B 必然会成为根节点
 * 平衡后的子树，接入原来的根的位置(判断原来跟是左子树还是右子树)
 *
 *
 * 平衡后的结构一定为
 *              B
 *         A         C
 *     T0    T1  T2    T3
 *
 */
public class AVLTree extends BSTTree{


    /**
     *
     * @param node
     * @return
     */
    public boolean balance(BinTreeNode node) {

        if(node == null) {
            return true;
        }

        int lifeHeight = node.hasLeft() ? node.getLeftChild().getHeight() : -1; // 如果有左子树则返回左子树的高
        int rightHeight = node.hasRight() ? node.getRightChild().getHeight() : -1; // 如果有右子树则返回右子树的高

        // 左右高度相减的绝对值小于等于1 则判断为失衡
        return Math.abs(lifeHeight - rightHeight) > 1;
    }

    /**
     * 返回指定节点中较高的子树
     * @param node
     * @return
     */
    public BinTreeNode heightSubT(BinTreeNode node) {

        if(node == null) {
            return null;
        }

        int lifeHeight = node.hasLeft() ? node.getLeftChild().getHeight() : -1;
        int rightHeight = node.hasRight() ? node.getRightChild().getHeight() : -1;

        if(lifeHeight > rightHeight) {
            return node.getLeftChild();
        } else if(lifeHeight < rightHeight) {
            return node.getRightChild();

            // 如果相等则判断节点是左子树还是右子树
        } else if(node.isLeftChild()) {
            return node.getLeftChild();
        } else {
            return node.getRightChild();
        }

    }


    /**
     *
     * @param z     失衡节点
     * @return      重新平衡后的局部根节点
     */
    private BinTreeNode rotate(BinTreeNode z) {
        // 获取目标节点较高的子树
        BinTreeNode y = heightSubT(z);
        // 获取y节点较高的子树
        BinTreeNode x = heightSubT(y);

        // 记录目标节点是否是左孩子（失衡四种情况）
        boolean isLiftChild = z.isLeftChild();
        // 获取目标节点的父节点
        BinTreeNode parentNode = z.getParent();

        // 声明三个节点
        BinTreeNode c, b, a;
        // 声明四棵子树
        BinTreeNode t0, t1, t2, t3;


        // 分四种情况 分别确认三个节点，四棵子树
        // 失衡由左子树造成
        if(y.isLeftChild()) {

            // 左失衡最顶上的节点都为 c t3 等于c的右子树节点
            c = z; t3 = z.getRightChild();

            // 左左失衡
            if(x.isLeftChild()) {
                b = y; t2 = y.getRightChild();
                a = x; t1 = x.getRightChild(); t0 = x.getLeftChild();

                // 左右失衡
            } else {
                a = y; t0 = y.getLeftChild();
                b = x; t1 = x.getLeftChild(); t2 = x.getRightChild();

            }

            // 失衡由右子树造成
        } else {

            // 右失衡最顶上的节点都为 a t0 等于c的右子树节点
            a = z; t0 = z.getLeftChild();
            // 右右失衡
            if(x.isRightChild()) {
                b = y; t1 = b.getLeftChild();
                c = x; t2 = x.getLeftChild(); t3 = x.getRightChild();

                // 右左失衡
            } else {
                c = y; t3 = y.getRightChild();
                b = x; t1 = x.getLeftChild(); t2 = x.getRightChild();
            }
        }

        // 断开三个节点
        a.sever();
        b.sever();
        c.sever();

        // 断开四棵子树
        if(t0 != null) {
            t0.sever();
        }
        if(t1 != null) {
            t1.sever();
        }
        if(t2 != null) {
            t2.sever();
        }
        if(t3 != null) {
            t3.sever();
        }

        // 重新连接节点构成平衡
        a.setLeftChild(t0); a.setRightChild(t1);
        c.setLeftChild(t2); c.setRightChild(t3);
        b.setLeftChild(a);  b.setRightChild(c);

        if(parentNode != null) { // 等于null 说明z 是root 节点此时返回的 b 就是新的root （自下而上平衡）
            // 重新插入父节点
            if (isLiftChild) {
                parentNode.setLeftChild(b);
            } else {
                parentNode.setRightChild(b);
            }
        }

        return b;
    }


    /**
     * 从指定节点开始逐渐往上检查平衡，并平衡树
     * @param node
     * @return
     */
    private BinTreeNode reBalance(BinTreeNode node) {
        if(node == null) {
            return getRoot();
        }

        BinTreeNode v = node;

        while(node != null) {   // 从node 开始逐渐往上检查失衡

            if(balance(node)) { // 入股失衡则平衡，平衡后node会等于局部平衡后的 局部root 节点
                node = rotate(node);
            }

            v = node;
            node = node.getParent();    // 继续检查父节点
        }

        return v;
    }

    @Override
    public BinTreeNode insert(Object ele, Strategy strategy) {
        BinTreeNode node = super.insert(ele, strategy);
        setRoot(reBalance(getStartBN()));
        return node;
    }

    @Override
    public Object remove(Object e, Strategy strategy) {
        Object obj = super.remove(e, strategy);
        setRoot(getStartBN());
        return obj;
    }
}
