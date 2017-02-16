package datastructure.search.searchTree.bst;

import org.junit.Before;
import org.junit.Test;

import datastructure.Node;
import datastructure.line.nodeList.doubleNodeList.DLNode;
import datastructure.line.nodeList.doubleNodeList.Iterator.Iterator;
import datastructure.nodeList.DefaultStrategy;
import datastructure.tree.binTree.BinTreeNode;

/**
 * Created by wangning on 17/2/6.
 */
public class BSTTreeTest {

    private BSTTree a;

    private BSTTree b;

    private  BSTTree g;

    private BSTTree d;

    /**
     *
     *          15A
     *      8B       17C
     *   6D    9E   16F   20G
     *
     *
     */
    @Before
    public void before() {
        System.out.println("建立基础二叉树结构");

        a = new BSTTree();
        a.setRoot(a);
        a.setData(15);
        b = new BSTTree();
        b.setRoot(a);
        b.setData(8);
        BSTTree c = new BSTTree();
        c.setRoot(a);
        c.setData(17);
        d = new BSTTree();
        d.setData(6);
        d.setRoot(a);
        BSTTree e = new BSTTree();
        e.setData(9);
        e.setRoot(a);
        BSTTree f = new BSTTree();
        f.setData(16);
        f.setRoot(a);
        g = new BSTTree();
        g.setData(20);
        g.setRoot(a);

        a.setLeftChild(b);
        a.setRightChild(c);
        b.setLeftChild(d);
        b.setRightChild(e);
        c.setLeftChild(f);
        c.setRightChild(g);

    }

    /**
     * 二叉树的查找测试
     */
    @Test
    public void test1() {

        Node result = a.search(17, new DefaultStrategy() {
            @Override
            public int compare(Object obj1, Object obj2) {
                Integer o1 = (Integer)obj1;
                Integer o2 = (Integer)obj2;

                return o1.compareTo(o2);
            }
        });

        System.out.println(result == null ? "没找到元素" : "元素值为" + result.getData());

    }

    /**
     * 二叉树的最大最小值测试
     */
    @Test
    public void test2() {

        Integer max = (Integer) a.max().getData();
        Integer min = (Integer) a.min().getData();

        System.out.println("预期最大值20，最小值6");
        System.out.println("实际最大值：" + max);
        System.out.println("实际最小值：" + min);
    }


    /**
     * 二叉树的插入测试
     */
    @Test
    public void test3() {
        System.out.println();
        System.out.println();

        System.out.println("插入前排序");

        Iterator it = a.inorderOrder();
        while (!it.isDone()) {
            DLNode b = (DLNode)it.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it.next();
        }


        a.insert(7, new DefaultStrategy() {
            @Override
            public int compare(Object obj1, Object obj2) {
                Integer o1 = (Integer)obj1;
                Integer o2 = (Integer)obj2;

                return o1.compareTo(o2);
            }
        });


        System.out.println();
        System.out.println();

        System.out.println("插入后排序");

        Iterator it2 = a.inorderOrder();
        while (!it2.isDone()) {
            DLNode b = (DLNode)it2.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it2.next();
        }


    }


    /**
     * 二叉树的前驱后驱测试
     */
    @Test
    public void test4() {

        BinTreeNode a1 = (BinTreeNode) b.getPre();
        BinTreeNode a2 = (BinTreeNode) b.getNext();

        System.out.println("当前元素：" + b.getData());
        System.out.println("前驱元素：" + a1.getData());
        System.out.println("后驱元素：" + a2.getData());

        System.out.println();
        System.out.print("最左元素是否有前驱节点：");
        System.out.println(d.getPre() != null);
        System.out.println(d.getPre());
        System.out.println();
        System.out.print("最右元素是否有后驱节点：");
        System.out.println(g.getNext() != null);
        System.out.println(g.getNext());

    }


    /**
     * 二叉树的删除测试
     */
    @Test
    public void test5() {

        System.out.println("删除前排序");
        Iterator it = a.inorderOrder();
        while (!it.isDone()) {
            DLNode b = (DLNode)it.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it.next();
        }

        System.out.println("删除前的根节点：" + a.getRoot().getData());


        a.remove(15, new DefaultStrategy() {
            @Override
            public int compare(Object obj1, Object obj2) {
                Integer o1 = (Integer)obj1;
                Integer o2 = (Integer)obj2;

                return o1.compareTo(o2);
            }
        });

        System.out.println("删除后排序");
        Iterator it2 = a.inorderOrder();
        while (!it2.isDone()) {
            DLNode b = (DLNode)it2.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it2.next();
        }


    }



}
