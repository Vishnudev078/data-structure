import java.util.*;
import java.lang.*;
import java.io.*;

class A implements Runnable {
    int lim;

    public A(int lim) {
        this.lim = lim;
    }

    public void run() {
        for (int i = 2; i <= lim; i++) {

            if (i % 2 == 0) {
                System.err.println(i);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}

class B implements Runnable {
    int lim;

    public B(int lim) {
        this.lim = lim;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            /*
             * if (i == 1) {
             * System.out.println("1");
             * }
             */
            if (i % 2 != 0) {
                System.err.println(i);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}

public class run {
    public static void main(String[] args) {
        System.out.println("Enter the limit");
        Scanner sr = new Scanner(System.in);
        int lim = sr.nextInt();
        Runnable obj = new A(lim);
        Runnable obj1 = new B(lim);
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj1);
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        t2.start();
    }
}
