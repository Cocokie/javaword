package com.lix.customize;

public class Customize {
    enum CycleStatus {
        FREE, RUNNING, BLOCK, DEAD;
    }

    public static void main(String[] args) {

        System.out.println(CycleStatus.BLOCK.equals(CycleStatus.DEAD));
    }
}
