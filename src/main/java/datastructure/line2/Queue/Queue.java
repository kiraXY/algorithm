package datastructure.line2.Queue;

/**
 * Created by wangning on 2017/2/16.
 */
 interface Queue {
    //返回队列的大小
    int getSize();
    //判断队列是否为空
    boolean isEmpty();
    //数据元素 e 入队
    void enqueue(Object e);
    //队首元素出队
     Object dequeue() throws QueueEmptyException; //取队首元素
     Object peek() throws QueueEmptyException;

}
