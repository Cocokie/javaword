package com.lix.threadmodel.templatemodel;

public class TemplateModelTest {
    public static void main(String[] args) {
        IMyRunnable im = new IMyRunnable();
        ThreadTemplate threadTemplate = new ThreadTemplate(im);
        threadTemplate.realAction("sd");
    }
}

class IMyRunnable implements MyRunnable {

    public void action() {
        System.out.println("runnable中的策略");
    }
}
