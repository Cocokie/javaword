package com.lix.customize;

public class A implements Comparable{
    private String a="haha";
    public A(){

    }

    public A(String a) {
        this.a = a;
    }

    public A(int k){
        System.out.println(k);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a1 = (A) o;

        return a != null ? a.equals(a1.a) : a1.a == null;
    }

    @Override
    public int hashCode() {
        return a != null ? a.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                '}';
    }

    public int compareTo(Object o) {
        return 1;
    }
}
