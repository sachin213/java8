package mutithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MultiLockSync {

    /**
     * common method(dowork1,dowork2) which is shared by  common thread process t1,t2 , if it's doing manipulation on different object rather then making method
     * synchronized we should make object synchronized to make performace better
     */

    Random r = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public void process() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                doWork();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
              doWork();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t2.start();
        t1.join();
        t2.join();

        Long endTime = System.currentTimeMillis();

        System.out.println("total time :"+(endTime-startTime));

        System.out.println("list1 size"+list1.size());
        System.out.println("list2 size"+list2.size());


    }

    private void doWork() throws InterruptedException {
        for(int i = 0;i <1000; i++){
            doWork1();
            doWork2();
        }
    }

    //public synchronized void doWork() throws InterruptedException { // it will work but will impact performance
        public  void doWork1() throws InterruptedException { // it will work but will impact performance
            synchronized (lock1) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    list1.add(r.nextInt(100));
                }
            }

    public  void doWork2() throws InterruptedException { // it will work but will impact performance
        synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list2.add(r.nextInt(100));
        }
    }
    public static void main(String[] args) throws InterruptedException {

        MultiLockSync multiLockSync = new MultiLockSync();
            multiLockSync.process();

    }
}
