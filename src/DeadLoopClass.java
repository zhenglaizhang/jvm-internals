/**
 * Created by Zhenglai on 7/25/16.
 */

class DeadClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {
            }
        }
    }
}

public class DeadLoopClass {
    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeadClass dead = new DeadClass();
                System.out.println(Thread.currentThread() + " end");
            }
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}
