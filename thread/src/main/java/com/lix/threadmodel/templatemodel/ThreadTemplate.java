package com.lix.threadmodel.templatemodel;

/**
 * 模板设计模式
 * Thread中的start方法中调用了run方法，实际我们只需要重写run方法
 */
public class ThreadTemplate implements MyRunnable{
    MyRunnable myRunnable;

    public ThreadTemplate(String info, MyRunnable myRunnable) {
        this.myRunnable = myRunnable;
    }
    public ThreadTemplate(MyRunnable myRunnable) {
        this.myRunnable = myRunnable;
    }

    private final void beginDoSomething() {
        System.out.println("beginDoSomething");
    }

    private final void endDoSomething() {
        System.out.println("endDoSomething");
    }

     public void action() {
        if(myRunnable!=null){
            myRunnable.action();
        }
    }

    public final void realAction(String action) {
        beginDoSomething();
        action();
        endDoSomething();
    }
}
