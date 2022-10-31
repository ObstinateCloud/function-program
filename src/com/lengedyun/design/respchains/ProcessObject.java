package com.lengedyun.design.respchains;

/**
 * @title: ProcessObject
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/26 15:51
 */
public abstract class ProcessObject<T> {

    protected ProcessObject<T> successor;

    public void setSuccessor(ProcessObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input){
        T t = handleWork(input);
        if (successor !=null){
            return successor.handle(t);
        }
        return t;
    }

    abstract protected  T handleWork(T input);
}
