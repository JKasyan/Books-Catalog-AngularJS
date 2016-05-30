package catalog.angularjs.dao;

/**
 * Created by evgen on 28.02.16.
 */
public class A {

    protected final int a = 20;

    {
        System.out.println("class A");
    }

    public A() {
        System.out.println("constructor A");
    }
}

class B extends A {

    protected int b = 5;

    {
        System.out.println("class B");
    }

    public B() {
        System.out.println("constructor B");
    }
}

class Main {

    public static void main(String[] args) {
        B b = new B();
    }
}
