package datastructure.line2.nodeList;

import datastructure.strategy.Strategy;

/**
 * Created by wangning on 2017/2/14.
 */
public class DefaultStrategy implements Strategy {
    @Override
    public int compare(Object obj1, Object obj2) {

        return 1;
    }

    @Override
    public boolean equal(Object data, Object obj) {
        return false;
    }
}
