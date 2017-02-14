package datastructure.search.searchTree.bst;

import datastructure.Node;
import datastructure.strategy.Strategy;
import datastructure.tree.binTree.BinTreeNode;

/**
 * Created by wangning on 17/2/8.
 *
 * BST 树， 二叉查找树
 *
 * 左子树不空 则左子树所有节点不大于根节点 右子树不空 则右子树所有节点不小于根节点 左右子树都是二叉树
 *
 * 二叉查找树的基本查找方法从根节点开始，递归缩小查找方位， 直到发现目标元素位置（查找成功）或查找范围缩小为空树（查找失败）
 */
public class BSTTree extends BinTreeNode {

    /**
     * 记录root 节点
     * 用static 修饰，方便全局修改root 节点的指向
     */
    private static BinTreeNode root;

    /** 待平衡出发点 */
    private BinTreeNode startBN;

    public BinTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinTreeNode root) {
        this.root = root;
    }

    public BinTreeNode getStartBN() {
        return startBN;
    }

    public void setStartBN(BinTreeNode startBN) {
        this.startBN = startBN;
    }

    /**
     * 查找方法
     * 
     * @param ele
     * @return 节点元素
     */
    public Node search(Object ele, Strategy strategy) {

        return binTSearchRecursion(root, ele, strategy);
    }

    /**
     * 根据 BST 的特性 递归查找指定元素
     * 
     * @param node
     * @param ele
     * @param strategy
     * @return
     */
    private Node binTSearchRecursion(BinTreeNode node, Object ele, Strategy strategy) {

        // recursion out
        if (node == null) {
            return null;
        }

        int result = strategy.compare(node.getData(), ele);

        switch (result) {
            // 相等直接返回
            case 0:
                return node;
            // 节点小于元素 说明元素在右子树
            case -1:
                return binTSearchRecursion(node.getRightChild(), ele, strategy);
            // 节点大于元素 说明元素在左子树
            default:
                return binTSearchRecursion(node.getLeftChild(), ele, strategy);
        }

    }

    /**
     * 二叉查找
     * 
     * @param node
     * @param ele
     * @param strategy
     * @return
     */
    private Node binTSearch(BinTreeNode node, Object ele, Strategy strategy) {

        while (node != null) {
            switch (strategy.compare(node.getData(), ele)) {
                // 相等直接返回
                case 0:
                    return node;
                // 节点小于元素 说明元素在右子树
                case -1:
                    node = node.getRightChild();
                    // 节点大于元素 说明元素在左子树
                default:
                    return node = node.getLeftChild();
            }
        }

        return null;
    }

    /**
     * 获取最大值
     * 
     * @return
     */
    public Node max() {
        BinTreeNode node = root;

        while (node.hasRight()) {
            node = node.getRightChild();
        }

        return node;
    }

    /**
     * 获取目标节点的最大值
     * 
     * @param node
     * @return
     */
    public Node max(BinTreeNode node) {

        while (node.hasRight()) {
            node = node.getRightChild();
        }

        return node;
    }

    /**
     * 获取最小值
     * 
     * @return
     */
    public Node min() {
        BinTreeNode node = root;

        while (node.hasLeft()) {
            node = node.getLeftChild();
        }

        return node;
    }

    /**
     * 获取目标节点的最小值
     * 
     * @return
     */
    public Node min(BinTreeNode node) {

        while (node.hasLeft()) {
            node = node.getLeftChild();
        }

        return node;
    }

    /**
     * 获取前驱元素 根据左小右大得出 如果该节点有左孩子，则会是左子树中最大的那个元素 如果是右孩子 则前驱是父节点
     *
     * @return
     */
    public Node getPre() {

        BinTreeNode node = this;

        if (node == null) {
            return null;
        }

        if (node.hasLeft()) {
            return max(node.getLeftChild());
        }

        // 如果节点是右孩子，说明比父节点大
        if (node.isRightChild()) {
            return node.getParent();
        }

        return null;
    }

    /**
     * 获取后驱元素 节点v的前驱元素是比v小的节点中最大的（左子树中最大的），比v大的右子树中最小的
     *
     * 1. 如果目标有右子树，那么后驱元素为，右子树中最小的（右子树的最左节点，没有则右子树的 起始节点） 2. 吐过目标没有右子树，那么后驱元素为 该节点到 root 节点这条路径上 第一个遇到的 是父节点左孩子的节点的父节点
     * 如果v是右孩子，往root 节点逆推，遇到第一个左孩子节点，说明v比该节点大（v在该节点的右子树上，该节点是父元素的左节点，说明父元素大于v） （大于节点的会成为节点的右孩子，小于节点的会成为左孩子）
     *
     * 如果v是左孩子，则直接取父节点
     *
     * @return
     */
    public Node getNext() {

        BinTreeNode node = this;

        if (node == null) {
            return node;
        }

        if (node.hasRight()) { // 如果有右子树
            return min(node.getRightChild()); // 返回右孩子中最小的节点为后置元素
        }

        while (node.isRightChild()) { // 如果是父节点的右孩子，则一直往上逆推（不是时说明碰上左孩子）
            node = node.getParent();
        }

        return node.getParent(); // 返回第一个遇到是左孩子的节点的父节点 如果是最右孩子到达root 后返回null

    }

    /**
     * 插入元素
     *
     * 一直到空节点插入(BST中插入节点总是作为叶子节点) 根据二叉树的定义 比当前节点小的往左， 比当前节点大的往右，一直到null 位置，之后成为叶子节点
     * 
     * @param ele
     */
    public BinTreeNode insert(Object ele, Strategy strategy) {

        BinTreeNode current = root; // 当前节点（最后可能为空）
        BinTreeNode currentParent = null; // 当前节点的父节点

        while (current != null) {
            currentParent = current;

            if (strategy.compare(current.getData(), ele) > 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        // 待平衡出发点
        startBN = currentParent;
        BinTreeNode node = null;
        if (currentParent == null) { // 树为空时直接插入root节点
            root = new BinTreeNode();
            root.setData(ele);
        } else if (strategy.compare(currentParent.getData(), ele) > 0) {
            node = new BinTreeNode();
            node.setData(ele);
            currentParent.setLeftChild(node);
        } else {
            node = new BinTreeNode();
            node.setData(ele);
            currentParent.setRightChild(node);
        }

        return node;

    }

    /**
     * BST 的删除 分为三种情况
     *
     * 1. 待删除节点是叶子节点，没有左右子树（直接删除）
     *
     * 2. 待删除节点有左子树或者右子树， 该情况分两种
     *      1. 该节点是父节点的左孩子，此时令左子树或右子树成为父节点的左孩子
     *      2. 该节点是父节点的右孩子，此时令左子树或右子树成为父节点的右孩子
     *
     * 3. 待删除节点既有左子树，又有右子树
     *      找到待删除元素的 前驱节点或后驱节点
     *      用前驱或后驱节点的值替换待删除节点的值
     *      删除前驱或后驱节点
     *      （谁替换了待删除节点删除谁，
     *                  前驱则是该节点为root 时左子树最右边的点 --> 左子树中最大的，该节点不会存在左孩子
     *                  后驱则是该节点为root 时右子树最左边的点 --> 右子树中最小的，该节点不会存在右孩子）
     *
     * @param e
     * @param strategy 策略模式，自定义排序
     * @return
     */
    public Object remove(Object e, Strategy strategy) {

        BSTTree v = (BSTTree)search(e, strategy);

        // 查找不到要删除数据时，直接返回null
        if(v == null) {
            return null;
        }

        BinTreeNode del = null;         // 待删除节点
        BinTreeNode subT = null;        // 待删除节点的子树

        // 确认待删除节点
        if(!v.hasLeft() || !v.hasRight()) { // 短路或，判断是否有左右子树，都没有则确认为待删除节点(短路或，有一个就会成真)
            del = v;

            // 进入else 则说明拥有左右子树
        } else {

            // 获取前驱元素
            del = (BinTreeNode) v.getPre();
            // 和前驱元素交换值
            v.setData(del.getData());
            del.setData(v.getData());
        }

        // 待平衡出发点
        startBN = del.getParent();
        // 确认是否有子树
        if(del.hasLeft()) {
            subT = del.getLeftChild();
        } else {
            subT = del.getRightChild();
        }

        // 删除操作
        // 有子树的情况
        if(subT != null) {

            if(del.isLeftChild()) {
                del.getParent().setLeftChild(subT);
            } else {
                del.getParent().setRightChild(subT);
            }

            // 没有子树的时候说明为叶子节点直接删除
        } else {
            del.sever();
        }

        return del.getData();
    }

}
