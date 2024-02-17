package mutithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperation {

    //volatile int  count = 0; / rather then pointing out to cache memory it's point out to main memory
    // so with volatile it's resolve visibility issue but not atomic operation issue as increment is devided in 3 part, get ,update and set
    //Here Atomic class give us guarantee on atomic operation
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicOperation atomicOperation = new AtomicOperation();
        atomicOperation.doWork();
    }

    public void doWork() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i=0;i<1000;i++){
                atomicInteger.addAndGet(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i=0;i<1000;i++){
                atomicInteger.addAndGet(1);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        if(atomicInteger.get() == 2000) System.out.println("It's match "+atomicInteger.get());
        else System.out.println("it does not match"+atomicInteger.get());
    }
}
