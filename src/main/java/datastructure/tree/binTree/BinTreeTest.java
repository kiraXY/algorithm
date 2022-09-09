package datastructure.tree.binTree;




import datastructure.line.nodeList.doubleNodeList.DLNode;
import datastructure.line.nodeList.doubleNodeList.Iterator.Iterator;

/**
 * Created by wangning on 17/2/6.
 */
public class BinTreeTest {

    private BinTreeNode a;

    /**
     *
     *          A
     *      B       C
     *   D    E   F   G
     *
     *   先序遍历 结果为
     *   A BDE CFG
     *
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
     *
     *
     */
    
    public void before() {
        System.out.println("建立基础二叉树结构");

        a = new BinTreeNode();
        a.setData("A");
        BinTreeNode b = new BinTreeNode();
        b.setData("B");
        BinTreeNode c = new BinTreeNode();
        c.setData("C");
        BinTreeNode d = new BinTreeNode();
        d.setData("D");
        BinTreeNode e = new BinTreeNode();
        e.setData("E");
        BinTreeNode f = new BinTreeNode();
        f.setData("F");
        BinTreeNode g = new BinTreeNode();
        g.setData("G");

        a.setLeftChild(b);
        a.setRightChild(c);
        b.setLeftChild(d);
        b.setRightChild(e);
        c.setLeftChild(f);
        c.setRightChild(g);

        System.out.println("A的高度 :" +  a.getHeight());

    }

    
    public void test() {
        System.out.println("开始遍历");
        Iterator it = a.preOrder();

        while(!it.isDone()) {
            DLNode b = (DLNode)it.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it.next();
        }

    }

    
    public void test2() {
        System.out.println("开始遍历");
        Iterator it = a.postOrder();

        while(!it.isDone()) {
            DLNode b = (DLNode)it.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it.next();
        }
    }



    
    public void test3() {
        System.out.println("开始查找");

        String find1 = "A";
        String find2 = "我234";

        BinTreeNode a1 = a.find(find1);
        BinTreeNode a2 = a.find(find2);

        System.out.println(a1 == null ? false : true);
        System.out.println(a2 == null ? false : true);

    }

}
