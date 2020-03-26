package com.lix.threadpool;

import lombok.Synchronized;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: javaworld
 * @description: simple-pool
 * @author: lixin
 * @create: 2020-03-26 08:55
 **/
public class SimpleThreadPool {
    private int currentSize;
    private static final Integer DEFAULT_SIZE = 3;
    private static final ThreadGroup THREAD_GROUP = new ThreadGroup("POOL_GROUP");
    private static final String THREAD_NAME_PREFIX = "name_LX";
    private static int threadNumber = 0;
    private static final LinkedList<Runnable> task = new LinkedList<>();

    private static final List<TaskWork> thread = new ArrayList<>();

    private Boolean isDestroy = false;

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.currentSize = size;
        init();
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Boolean getDestroy() {
        return isDestroy;
    }

    private void init() {
        for (int i = 0; i < currentSize; i++) {
            TaskWork runnable = generateTaskWork();
            thread.add(runnable);
            runnable.start();
        }
    }

    private TaskWork generateTaskWork() {
        return new TaskWork(CycleStatus.FREE);
        // return
    }

    public void submitTask(Runnable runnable) {
        synchronized (task) {
            task.add(runnable);
            task.notifyAll();

        }
    }

    public void shutDown() {
        this.thread.forEach(thread1 -> {
            while (thread1.cycleStatus.equals(CycleStatus.RUNNING)) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (task) {
                while (thread1.cycleStatus.equals(CycleStatus.BLOCK)) {
                    thread1.interrupt();
                    thread1.cycleStatus = CycleStatus.DEAD;
                }
            }
            thread1.cycleStatus = CycleStatus.DEAD;
            currentSize--;
        });
        isDestroy = true;
    }

    enum CycleStatus {
        FREE, RUNNING, BLOCK, DEAD;
    }

    //不能只把这个当作线程，应该是一个可以运行任务的机器
    private class TaskWork extends Thread {
        private volatile CycleStatus cycleStatus;

        public TaskWork(CycleStatus cycleStatus) {
            super(THREAD_GROUP, THREAD_NAME_PREFIX + threadNumber++);
            this.cycleStatus = cycleStatus;
        }

        @Override
        public void run() {
            OUT:
            while (!this.cycleStatus.equals(CycleStatus.DEAD)) {
                Runnable runnable;
                synchronized (task) {
                    while (task.isEmpty()) {
                        try {
                            this.cycleStatus = CycleStatus.BLOCK;
                            System.out.println(Thread.currentThread().getName() + "  阻塞中");
                            task.wait();
                        } catch (InterruptedException e) {
                            System.out.println(this.cycleStatus + "  激活了gg" + Thread.currentThread().getName());
                            break OUT;
                        }
                    }
                    runnable = task.removeLast();
                }
                this.cycleStatus = CycleStatus.RUNNING;
                runnable.run();
                this.cycleStatus = CycleStatus.FREE;
            }

        }

        public void close() {
            this.cycleStatus = CycleStatus.DEAD;
        }
    }
}
