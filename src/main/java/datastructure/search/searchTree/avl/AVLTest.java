package datastructure.search.searchTree.avl;



import datastructure.line.nodeList.doubleNodeList.DLNode;
import datastructure.line.nodeList.doubleNodeList.Iterator.Iterator;
import datastructure.strategy.Strategy;
import datastructure.tree.binTree.BinTreeNode;

/**
 * Created by wangning on 17/2/12.
 */
public class AVLTest {

    private AVLTree a1;

    private BinTreeNode a2;

    public void before() {

        a1 = new AVLTree();
        a1.setData(15);
        a1.setRoot(a1);

//        AVLTree a2  = new AVLTree();
//        a2.setData(6);
//        a2.setRoot(a1);
//        a1.setLeftChild(a2);
//
//        AVLTree a3  = new AVLTree();
//        a3.setData(3);
//        a3.setRoot(a1);
//        a1.setLeftChild(a2);
//
//
//        AVLTree a4  = new AVLTree();
//        AVLTree a5  = new AVLTree();
//        AVLTree a6  = new AVLTree();
//        AVLTree a7  = new AVLTree();
//        AVLTree a8  = new AVLTree();
//        AVLTree a9  = new AVLTree();
//        AVLTree a10  = new AVLTree();
//        AVLTree a11  = new AVLTree();
//        AVLTree a12  = new AVLTree();
//        AVLTree a13  = new AVLTree();
//        AVLTree a14  = new AVLTree();
//        AVLTree a15  = new AVLTree();
//        AVLTree a16  = new AVLTree();


        Strategy strategy = new Strategy() {
            @Override
            public int compare(Object obj1, Object obj2) {
                Integer o1 = (Integer)obj1;
                Integer o2 = (Integer)obj2;

                return o1.compareTo(o2);
            }

            @Override
            public boolean equal(Object data, Object obj) {
                return false;
            }
        };

        a1.insert(6, strategy);
        a1.insert(3, strategy);
        a1.insert(7, strategy);
        a1.insert(4, strategy);
        a2 = a1.insert(13, strategy);
        a1.insert(18, strategy);
        a1.insert(17, strategy);
        a1.insert(20, strategy);

        System.out.println(a2.getData());

    }


    
    public void test() {

        System.out.println("插入前排序");

        Iterator it = a2.inorderOrder();
        while (!it.isDone()) {
            DLNode b = (DLNode)it.currentItem();
            BinTreeNode c = (BinTreeNode) b.getData();
            System.out.println(c.getData());
            it.next();
        }

        System.out.println("当前的根节点：" + a1.getRoot().getData());

    }
}
