package datastructure.tree.binTree;

import datastructure.Node;
import datastructure.line.nodeList.doubleNodeList.LinkedList;
import datastructure.line.nodeList.doubleNodeList.LinkedListDLNote;
import datastructure.line.nodeList.doubleNodeList.Iterator.Iterator;
import datastructure.line.stack.Stack;
import datastructure.line.stack.stackLinked.StackSLLinked;

/**
 * Created by wangning on 17/2/5.
 *
 * 二叉树节点的定义
 *
 */
public class BinTreeNode implements Node {

    /**
     * 数据域
     */
    private Object data;

    /**
     * 父节点
     */
    private BinTreeNode parent;

    /**
     * 左子节点
     */
    private BinTreeNode leftChild;

    /**
     * 右子节点
     */
    private BinTreeNode rightChild;

    /**
     * 以该节点为root 的子树高度（高度由 根开始 根为1 深度由叶子开始 叶子为1 ） 叶子节点没有子节点
     */
    private int childTreeHeight;

    /**
     * 该树的后代数，包括自己
     */
    private int size;

    public void setParent(BinTreeNode parent) {
        this.parent = parent;
    }

    /** assist binTree status start */

    /**
     * 辅助判断父节点是否为空
     * @return
     */
    public boolean hasParent() {
        return parent != null;
    }

    /**
     * 辅助判断是否有左节点
     * @return
     */
    public boolean hasLeft() {
        return leftChild != null;
    }

    /**
     * 辅助判断是否有右节点
     * @return
     */
    public boolean hasRight() {
        return rightChild != null;
    }

    /**
     * 辅助判断是否是叶子节点
     * @return
     */
    public boolean isLeaf() {
        return (!hasLeft() && !hasRight());
    }

    /**
     * 辅助判断是否是某个节点的 左节点
     * @return
     */
    public boolean isLeftChild() {

        // 父节点不为空 且 本身等于父节点的左孩子
        return (hasParent() && this == parent.leftChild);
    }

    /**
     * 辅助判断是否是某个节点的 右节点
     * @return
     */
    public boolean isRightChild() {

        // 父节点不为空 且 本身等于父节点的右孩子
        return (hasParent() && this == parent.rightChild);
    }

    /** assist binTree status end */

    /** assist height start */

    /**
     * 获取以该节点为根数的高度
     * @return
     */
    public int getHeight() {
        return childTreeHeight;
    }

    public void updateHeight() {

        int newHeight = 1; // 初始的高度为1， 新高度为左右子树中最高的一个值 + 1

        // 如果有左孩子
        if(hasLeft()) {
            newHeight = Math.max(newHeight, leftChild.getHeight() + 1);
        }

        // 如果有右孩子
        if(hasRight()) {
            newHeight = Math.max(newHeight, rightChild.getHeight() + 1);
        }

        // 如果高度不变直接 return
        if(childTreeHeight == newHeight) {
            return;
        }

        // 否则更新高度
        childTreeHeight = newHeight;

        // 递归更新父树
        if(hasParent()) {
            parent.updateHeight();
        }


    }

    /** assist height end */

    /** assist size start */

    /**
     * 获取以该节点为根 树 的节点树（包括自己）
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 更新以该节点为根 树 的节点树（包括自己）
     * @return
     */
    public void updateSize() {
        int size = 1; // 初始化节点数 （1 代表 自己这个节点）

        // 如果有右孩子饿， 加上右孩子的规模
        if(hasRight()) {
            size += rightChild.getSize();
        }

        // 如果有左孩子饿， 加上左孩子的规模
        if(hasLeft()) {
            size += leftChild.getSize();
        }

        // 递归更新先祖的规模
        if(hasParent()) {
            parent.updateSize();
        }
    }

    /** assist size end */

    /** assist parent start */

    /**
     * 获取父节点
     * @return
     */
    public BinTreeNode getParent() {
        return parent;
    }

    /**
     * 断开与父节点的联系
     */
    public void sever() {

        // 没有父节点直接 return
        if(!hasParent()) {
            return;
        }

        // 判断是父节点的左孩子 还是 右孩子 并断开
        if(isLeftChild()) {
            parent.leftChild = null;
        } else {
            parent.rightChild = null;
        }

        // 更新父元素的 高度 和 节点规模
        parent.updateSize();
        parent.updateHeight();

        // 断开与父元素的联系
        parent = null;

    }

    /** assist parent end */

    /** assist left start */

    public BinTreeNode getLeftChild() {
        return leftChild;
    }

    /**
     * 替换左孩子 并返回原先的做左孩子
     * @param newLeft
     * @return
     */
    public BinTreeNode setLeftChild(BinTreeNode newLeft) {

        if(newLeft == null) {
            return null;
        }
        // 当前左孩子
        BinTreeNode now = null;
        // 当前左孩子断开与父元素的连接
        if(hasLeft()) {
            now = this.leftChild;
            now.sever();
        }

        newLeft.sever(); // 断开原先父子关系
        // 新的左孩子
        this.leftChild = newLeft;
        // 建立新左孩子的父关系
        BinTreeNode temp = this;
        newLeft.setParent(temp);

        // 更新高度 和 规模
        updateHeight();
        updateSize();

        // 返回原先的左孩子
        return now;

    }

    /** assist left end */


    /** assist right start */

    /**
     * 获取右孩子
     * @return
     */
    public BinTreeNode getRightChild() {
        return rightChild;
    }

    /**
     * 替换右孩子 并返回原先的做右孩子
     * @param newRight
     * @return
     */
    public BinTreeNode setRightChild(BinTreeNode newRight) {

        if(newRight == null) {
            return null;
        }

        // 当前右孩子
        BinTreeNode now = null;
        // 当前右孩子断开与父元素的连接
        if(hasRight()) {
            now = this.rightChild;
            now.sever();
        }

        newRight.sever(); // 断开原先父子关系
        // 新的右孩子
        this.rightChild = newRight;
        // 建立新右孩子的父关系
        BinTreeNode temp = this;
        newRight.setParent(temp);

        // 更新高度 和 规模
        updateHeight();
        updateSize();

        // 返回原先的右孩子
        return now;

    }

    /** assist right end */


    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object obj) {
        this.data = obj;
    }


    /**
     * 递归遍历 树
     * 将树存为一个集合
     *
     */
    public Iterator preOrder() {
        LinkedList list = new LinkedListDLNote();
        // 从根节点开始
        preOrderRecursion(this, list);
        return list.elements();
    }


    /**
     *
     * 递归先序遍历
     * @param node 节点
     * @param list 保存节点的线性表
     */
    private void preOrderRecursion(BinTreeNode node, LinkedList list) {
        // 如果节点为空则返回
        if(node == null) {
            return;
        }

        // 否则将节点插入双向链表的最后
        list.insertLast(node);
        // 遍历左树
        preOrderRecursion(node.getLeftChild(), list);
        // 遍历右树
        preOrderRecursion(node.getRightChild(), list);
    }



    /**
     * 中序遍历
     * BST 中序转换后总能得到从小到大的 有序列表
     * @return
     */
    public Iterator inorderOrder() {
        LinkedList list = new LinkedListDLNote();
        inorderOrderTraverse(this, list);
        return list.elements();
    }

    /**
     * 中序遍历二叉树
     * @param node
     * @param list
     */
    public void inorderOrderTraverse(BinTreeNode node, LinkedList list) {

        BinTreeNode p = node;
        Stack stack = new StackSLLinked();

        while(p != null || !stack.isEmpty()) {

            while(p != null) {
                stack.push(p); // root 入栈
                if(p != null) {
                    p = p.getLeftChild();   // 最后一个节点时，P不等于null 进方法 当时p的左孩子为null p = null 后结束循环
                }
            }

            if(!stack.isEmpty()) {
                p = (BinTreeNode) stack.pop();
                list.insertLast(p);
                p = p.getRightChild();  // 到最左后 看最左是否有 右孩子（之后每往上一层都查看一次右孩子）
            }
        }

    }


    /**
     * 非递归遍历
     * @return
     */
    public Iterator postOrder() {
        LinkedList list = new LinkedListDLNote();
        postOrderTraverse(this, list);

        return list.elements();
    }

    /**
     * 非递归 后续遍历
     *   后续遍历 结果为
     *   DEB FGC A
     *   利用栈的特性
     *   1. 左边是否还有节点，有则入栈，直到没有左边元素
     *   2. 弹出元素
     *   3. 弹出的元素是否是上一个元素的右元素，是的话说明该元素的左右元素都访问过了，将该元素出栈
     *   4. 转向父元素的右边
     *   5. 转到父元素的右边后，先将右元素入栈，入栈后是否还有左？
     *      有则重复1
     *      没有重复2
     * @param node
     * @param list
     */
    private void postOrderTraverse(BinTreeNode node, LinkedList list) {
        // 如果节点为空则返回
        if(node == null) {
            return;
        }

        BinTreeNode p = node;
        // 利用栈 后进先出的特性
        Stack stack = new StackSLLinked();


        while(p != null || !stack.isEmpty()) { // p 等于null 时 如果 栈不为空集合则继续循环

            while(p != null) { // 先往左走
                stack.push(p);

                if(p.hasLeft()) { // 如果有左孩子则取左孩子
                    p = p.getLeftChild();

                } else { // 否则取右孩子， 到最左后会取得最左节点的 右孩子
                    p = p.getRightChild();
                }
            }

            if(!stack.isEmpty()) {
                p = (BinTreeNode) stack.pop();  // 取出栈顶元素
                list.insertLast(p);             // 保存进列表里
            }

            while(!stack.isEmpty() && p == ((BinTreeNode)stack.peek()).getRightChild()) {
                // 进入该代码段，说明节点已经访问过右边元素

                // 栈顶第一个元素的右孩子指向之前出栈的元素
                // 说明已经访问过右元素，应该将该节点出栈

                // 最后到根节点必然会进入该代码段
                p = (BinTreeNode) stack.pop();
                list.insertLast(p);
            }

            if(!stack.isEmpty()) {
                // 转向访问右边元素 节点不出栈
                p = ((BinTreeNode) stack.peek()).getRightChild();
            } else {
                p = null;
            }

        }

    }

    /**
     * 在二叉树中查找元素
     * @param e
     * @return
     */
    public BinTreeNode find(Object e) {
        return searchElement(this, e);
    }

    /**
     * 递归查找
     * @param node
     * @param e
     * @return
     */
    private BinTreeNode searchElement(BinTreeNode node, Object e) {

        // 如果节点为null 说明到底了返回 null
        if(node == null) {
            return null;
        }

        // 如果是该节点则返回该节点
        if(node.getData().equals(e)) {
            return this;
        }

        // 否则从左边子树开始找
        BinTreeNode v = searchElement(node.getLeftChild(), e);

        // 左边子树没有找到时，往右边子树开始找
        if(v == null) {
            v = searchElement(node.getRightChild(), e);
        }

        return v;
    }

}
